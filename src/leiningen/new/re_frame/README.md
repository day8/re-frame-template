# {{name}}

A [re-frame](https://github.com/Day8/re-frame) application designed to ... well, that part is up to you.

## Development Mode

{{#garden?}}### Compile css:

Compile css file once.

```
lein garden once
```

Automatically recompile css file on change.

```
lein garden auto
```

{{/garden?}}
### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

{{#test?}}### Run tests:

```
lein clean
lein cljsbuild auto test
```

{{/test?}}
## Production Build

```
lein clean
lein cljsbuild once min
```
