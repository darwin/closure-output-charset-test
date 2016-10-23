(ns closure-output-charset.core
  (:require [clojure.browser.repl :as repl]
            [cljsjs.vega]
            [goog.i18n.bidi :as bidi]))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(println "Hello world!")

(println "!" bidi/rtlChars_)                                                                                                  ; see https://github.com/google/closure-compiler/issues/1704
