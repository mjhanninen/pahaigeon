# Pahaigeon

A minimal example of how you could build Docker images for your Clojure
application with [tools.deps][tools-deps], [Badigeon][badigeon], and [GNU
Make][gnu-make]. This essentially codifies Christian Johansen's article
["Clojure in Production with tools.deps"][johansen].

[tools-deps]:https://github.com/clojure/tools.deps.alpha
[badigeon]: https://github.com/EwenG/badigeon
[gnu-make]: https://www.gnu.org/software/make/
[johansen]: https://cjohansen.no/clojure-in-production-tools-deps/

## Running from command line

```console
$ clojure -A:run
```

## Building Docker image

```console
$ make
```

## Running Docker image

```console
$ docker run -d -p 3000:3000 pahaigeon-app:latest
```
