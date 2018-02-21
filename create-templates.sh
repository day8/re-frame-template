#!/bin/bash

rm -r temp
mkdir temp
cd temp

printf "\ncreating base\n"
lein new re-frame base
cd base
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..

printf "\ncreating base +routes\n"
lein new re-frame base-routes +routes
cd base-routes
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..

printf "\ncreating base +re-com\n"
lein new re-frame base-recom +re-com
cd base-recom
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..

printf "\ncreating base +routes +re-com\n"
lein new re-frame base-routes-recom +routes +re-com
cd base-routes-recom
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..

printf "\ncreating base +cider +routes +re-com +test +garden +handler +less +re-frisk +aliases +10x\n"
lein new re-frame everything +cider +routes +re-com +test +garden +handler +less +re-frisk +aliases +10x
cd everything
lein build 			#  from +aliases
lein doo phantom test once
cd resources/public
google-chrome index.html
cd ../../..
