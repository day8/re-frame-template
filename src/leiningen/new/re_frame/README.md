# {{name}}

A [re-frame](https://github.com/Day8/re-frame) application designed to ... well, that part is up to you.

## Development Mode

{{#cider?}}### Start Cider from Emacs:

Put this in your Emacs config file:

```
(setq cider-cljs-lein-repl
	"(do (require 'figwheel-sidecar.repl-api)
         (figwheel-sidecar.repl-api/start-figwheel!)
         (figwheel-sidecar.repl-api/cljs-repl))")
```

Navigate to a clojurescript file and start a figwheel REPL with `cider-jack-in-clojurescript` or (`C-c M-J`)

{{/cider?}}
{{#garden?}}### Compile css:

Compile css file once.

```
lein garden once
```

Automatically recompile css file on change.

```
lein garden auto
```
{{#aliases?}}

CSS also gets automatically built when running `lein build` and recompiled on change with `lein dev`.
{{/aliases?}}

{{/garden?}}{{#less?}}### Compile css:

Compile css file once.

```
lein less once
```

Automatically recompile css file on change.

```
lein less auto
```
{{#aliases?}}

CSS also gets automatically built when running `lein build` and recompiled on change with `lein dev`.
{{/aliases?}}

{{/less?}}
### Run application:

{{#aliases?}}
```
lein dev
```
{{/aliases?}}
{{^aliases?}}
```
lein clean
lein figwheel dev
```
{{/aliases?}}

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

{{#test?}}### Run tests:

```
lein clean
lein doo phantom test once
```

The above command assumes that you have [phantomjs](https://www.npmjs.com/package/phantomjs) installed. However, please note that [doo](https://github.com/bensu/doo) can be configured to run cljs.test in many other JS environments (chrome, ie, safari, opera, slimer, node, rhino, or nashorn).

{{/test?}}
## Production Build

{{#handler?}}
```
lein clean
lein with-profile prod uberjar
```

That should compile the clojurescript code first, and then create the standalone jar.

When you run the jar you can set the port the ring server will use by setting the environment variable PORT.
If it's not set, it will run on port 3000 by default.

To deploy to heroku, first create your app:

```
heroku create
```

Then deploy the application:

```
git push heroku master
```
{{/handler?}}

To compile clojurescript to javascript:

{{#aliases?}}
```
lein build
```
{{/aliases?}}
{{^aliases?}}
```
lein clean
lein cljsbuild once min
```
{{/aliases?}}
