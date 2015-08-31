# re-frame-template

Leiningen template for [reagent](https://github.com/reagent-project/reagent) web apps that implements the [re-frame](https://github.com/Day8/re-frame) pattern.

Through the use of profiles, this template lets the developer pick and choose what is included in their application.

## Usage

The base template includes:

* [re-frame](https://github.com/Day8/re-frame)
* [figwheel](https://github.com/bhauman/lein-figwheel)

To create an application with the base template:

```
lein new re-frame <project-name>
```

The optional profiles include:

* [garden](https://github.com/noprompt/garden)(`+garden`)
* [re-com](https://github.com/Day8/re-com) (`+re-com`)
* [secretary](https://github.com/gf3/secretary) (`+routes`)
* [cljs.test](https://groups.google.com/forum/#!topic/clojure/gnCl0CySSk8) (`+test`)

To add a profile to the base template, just append the profile name (let's use `+re-com` as an example):

```
lein new re-frame <project-name> +re-com
```

Any combination of profiles can be added at once (let's add all the profiles as an example):

```
lein new re-frame <project-name> +garden +re-com +routes +test
```

## Development Mode

### Compile css (if using +garden):

Compile css file once.

```
lein garden once
```

Automatically recompile css file on change.

```
lein garden auto
```

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

### Run tests (if using +test):

```
lein clean
lein cljsbuild auto test
```

*Note: This requires [phantomjs](https://www.npmjs.com/package/phantomjs).*

## Production Build

```
lein clean
lein cljsbuild once min
```

## License

```
The MIT License (MIT)

Copyright © 2015 Matthew Jaoudi
Copyright © 2015 Dylan Paris
Copyright © 2015 Michael Thompson

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
