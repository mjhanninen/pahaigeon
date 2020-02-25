COMMIT := $(shell git rev-parse --short HEAD)
DEV_CLJ := $(shell git ls-files -- src-dev)
APP_CLJ := $(shell git ls-files -- src)

.PHONY: all clean docker-images

all: docker-images

clean:
	test -e target && rm -Rd target

docker-images: target/image-tags/pahaigeon-app Makefile

target/stamps/bundle: deps.edn $(DEV_CLJ) Makefile
	clojure -A:dev -m package bundle

target/stamps/compile: deps.edn $(DEV_CLJ) $(APP_CLJ) Makefile
	clojure -A:dev -m package compile

target/image-tags/pahaigeon-app: docker/Dockerfile \
		target/stamps/bundle \
		target/stamps/compile \
		Makefile
	@mkdir -p $(@D)
	cd target && docker build -t $(@F):$(COMMIT) -f ../$< . && docker tag $(@F):$(COMMIT) $(@F):latest
	echo "$(@F):$(COMMIT)" > $@
