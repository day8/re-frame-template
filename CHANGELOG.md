## Unreleased

#### Changed

- Upgrade re-frame-10x to [0.6.4](https://github.com/day8/re-frame-10x/blob/master/CHANGELOG.md#064---2020-05-01)
- Upgrade re-frame-debux to 0.5.5

## 1.0.29 (2020-04-30)

#### Fixed

- Fix missing clj-kondo config. See [#124](https://github.com/day8/re-frame-template/pull/124)

#### Changed

- Upgrade ClojureScript to [1.10.748](https://github.com/clojure/clojurescript/blob/master/changes.md)
- Upgrade shadow-cljs to 2.8.109
- Upgrade reagent to [0.10.0](https://github.com/reagent-project/reagent/blob/master/CHANGELOG.md#0100-2020-03-06)
- Upgrade re-frame to [0.12.0](https://github.com/day8/re-frame/blob/master/CHANGELOG.md#0120-2020-03-08)
- Upgrade re-com to [2.8.0](https://github.com/day8/re-com/blob/master/CHANGELOG.md#280-2020-03-08)
- Upgrade re-frame-10x to [0.6.3](https://github.com/day8/re-frame-10x/blob/master/CHANGELOG.md#063---2020-04-30)
- Upgrade re-frisk to 1.2.0
- Upgrade ring to [1.8.0](https://github.com/ring-clojure/ring/blob/master/CHANGELOG.md#180-2019-11-13)

## 1.0.28 (2020-02-14)

#### Changed

- Upgrade binaryage/devtools to 1.0.0
- Upgrade re-frame-10x to 0.5.1
- Upgrade re-com to 2.7.0

Overall these upgrades result in a consistent React version across all
dependencies of [16.9.0](https://reactjs.org/blog/2019/08/08/react-v16.9.0.html).

## 1.0.27 (2020-01-20)

#### Changed

- Upgrade reagent to 0.9.1
- Upgrade re-frame to 0.11.0

#### Fixed

- Some of the uberjar issues thanks to [Derek Passen](https://github.com/dpassen).
  See [#95](https://github.com/day8/re-frame-template/issues/95). 
- Add Garden/Less CSS compilation to build prep-tasks thanks to
  [@stevejmp](https://github.com/stevejmp).
- Add lein, node, shadow-cljs items to .gitignore thanks to
  [@stevejmp](https://github.com/stevejmp).

#### Added

- +kondo profile thanks to [@stevejmp](https://github.com/stevejmp).

#### Removed

- Remove clean from lein aliases to workaround [#95](https://github.com/day8/re-frame-template/issues/95).
- Unused test/cljs/runner.cljs thanks to [@stevejmp](https://github.com/stevejmp).
- Unused leiningen.new.options.helpers/invoke-option fn thanks to
  [@stevejmp](https://github.com/stevejmp).

## [1.0.26 (2019-12-18)](https://github.com/day8/re-frame-template/runs/352988356)

#### Fixed

- Fixed docs re lein aliases thanks to [@stevejmp](https://github.com/stevejmp)

#### Changed

- Upgrade shadow-cljs to 2.8.83
- Upgrade yogthos/config to 1.1.7

## [1.0.25 (2019-12-05)](https://github.com/day8/re-frame-template/runs/333630252)

#### Changed

- Upgrade shadow-cljs to 2.8.80

## [1.0.24 (2019-11-30)](https://github.com/day8/re-frame-template/runs/326469035)

#### Changed

- Upgrade shadow-cljs to 2.8.76
- Downgrade re-frame-10x to 0.4.4

#### Added

- Add org.clojure/google-closure-library-third-party exclusion to ClojureScript dependency

## [1.0.23 (2019-11-20)](https://github.com/day8/re-frame-template/runs/311234380)

#### Changed

- Upgrade [ClojureScript to 1.10.597](https://clojurescript.org/news/2019-11-18-release)
- Upgrade binaryage/devtools to 0.9.11
- Upgrade shadow-cljs to 2.8.73

## [1.0.22 (2019-11-02)](https://github.com/day8/re-frame-template/runs/285090579)

#### Changed

- Upgrade shadow-cljs to 2.8.69
- Upgrade re-frame-10x to 0.4.5
- Migrate to me.arrdem/lein-git-version 
- Migrate to GitHub Actions based continuous integration and continuous deployment

#### Added

- Add LICENSE. Maintains the same LICENSE (MIT) that has always been present in the README.md file. Just makes it more
  accessible and obvious.

## 1.0.21 (2019-10-30)

#### Changed

- Upgrade shadow-cljs to 2.8.68

## 1.0.20 (2019-10-24)

#### Added

- Add lein build-report alias
- Add clean to all lein aliases

#### Changed

- Rename lein karma-once alias to karma

#### Fixed

- Fix missing karma-junit-reporter dependency

## 1.0.19 (2019-10-24)

#### Changed

- Upgrade shadow-cljs to 2.8.67

## 1.0.18 (2019-10-22)

#### Changed

- Upgrade shadow-cljs to 2.8.65
- Upgrade karma to 4.4.1

## 1.0.17 (2019-10-18)

#### Fixed

- Import goog.history.EventType properly.
  See [#94](https://github.com/day8/re-frame-template/pull/94).
  Thanks to [@Wegi](https://github.com/Wegi).

#### Added

- Added lein karma-once alias

#### Changed

- Upgrade shadow-cljs to 2.8.64
- Upgrade yogthos/config to 1.1.6
- Upgrade karma to 4.4.0

## 1.0.16 (2019-10-15)

#### Changed

- Upgrade re-frame-10x to 0.4.4

## 1.0.15 (2019-10-11)

#### Changed

- Upgrade shadow-cljs to 2.8.62

## 1.0.14 (2019-10-09)

#### Changed

- Upgrade shadow-cljs to 2.8.61

## 1.0.13 (2019-09-27)

#### Changed

- Upgrade shadow-cljs to 2.8.59

## 1.0.12 (2019-09-25)

#### Changed

- Upgrade shadow-cljs to 2.8.58

## 1.0.11 (2019-09-25)

#### Changed

- Upgrade shadow-cljs to 2.8.57

## 1.0.10 (2019-09-24)

#### Changed

- Upgrade shadow-cljs to 2.8.56

## 1.0.9 (2019-09-22)

#### Changed

- Upgrade shadow-cljs to 2.8.55

## 1.0.8 (2019-09-20)

#### Changed

- Upgrade shadow-cljs to 2.8.53
- Upgrade re-com to 2.6.0
- Upgrade re-pressed to 0.3.1

## 1.0.7 (2019-09-11)

#### Changed

- Upgrade re-frame-10x to 0.4.3
- Upgrade lein-garden to 0.3.0

#### Removed

- Empty generated `core.clj` [#93](https://github.com/day8/re-frame-template/pull/93) 
  thanks to @thheller

## 1.0.6 (2019-08-28)

#### Changed

- Upgrade shadow-cljs to 2.8.52
- Upgrade re-frame to 0.10.9
- Upgrade karma to 4.3.0

## 1.0.5 (2019-08-24)

#### Fixed

- 1.0.4 introduced a regression whereby if the +10x profile was not used an
  extra bracket in `shadow-cljs.edn` would cause the build to fail. This is
  fixed in 1.0.5. See [#92](https://github.com/day8/re-frame-template/issues/92).

## 1.0.4 (2019-08-21)

#### Changed

- Greatly simplified shadow-cljs config thanks to @thheller
- Upgrade react-flip-move to 3.0.3. Fixes warning of depedency conflict with re-frame-10x.
- Upgrade karma-chrome-launcher to 3.1.0
- Upgrade to shadow-cljs 2.8.51

#### Fixed

- +cider profile adds -Xmx1G :jvm-opts as a workaround for Emacs cider-jack-in-cljs failure
  thanks to investigation and report by @Quezion

## 1.0.3 (2019-08-18)

#### Fixed

- Don't use unsafe version ranges in package.json

## 1.0.2 (2019-08-16)

#### Changed

- Upgrade shadow-cljs to 2.8.48

## 1.0.1 (2019-08-12)

#### Changed

- Upgrade shadow-cljs to 2.8.45

#### Removed

- Remove +gadfly profile

## 1.0.0 (2019-08-06)

#### Changed

- Migrate to shadow-cljs

## 0.3.23 (2019-07-15)

#### Changed

- Upgrade re-frame to 0.10.8

## 0.3.22 (2019-06-08)

#### Changed

- Upgrade compojure to 1.6.1
- Upgrade garden to 1.3.9
- Upgrade Clojure to 1.10.1
- Upgrade re-com to 2.5.0
- Upgrade re-pressed to 0.3.0
- Upgrade re-frame-10x to 0.4.0
- Upgrade ns-tracker to 0.4.0
- Upgrade re-frisk to 0.5.4.1
- Upgrade ring to 1.7.1
- Upgrade yogthos/config 1.1.2
- Upgrade figwheel-sidecar to 0.5.18
- Upgrade cider/piggieback to 0.4.1

## 0.3.20 (2019-03-12)

#### Fixed

- Ensure that .gitignore is created

## 0.3.19 (2019-03-11)

#### Changed

- Upgrade re-com to 2.4.0

#### Removed

- Transitive dependencies on cljs-time and core.async

## 0.3.18 (2019-03-11)

#### Changed

- Upgrade Clojure to 1.10.0
- Upgrade ClojureScript to 1.10.520
- Upgrade reagent to 0.8.1
- Upgrade re-frame to 0.10.6
