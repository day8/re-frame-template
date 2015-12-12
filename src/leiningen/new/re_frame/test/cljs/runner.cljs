(ns {{ns-name}}.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [{{ns-name}}.core-test]))

(doo-tests '{{ns-name}}.core-test)
