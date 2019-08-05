#!/bin/bash

rm -r temp
mkdir temp
cd temp

printf "\ncreating base\n"
lein new re-frame base
cd base
npm install
lein prod
cd resources/public
google-chrome index.html
cd ../../..

printf "\ncreating base +routes\n"
lein new re-frame base-routes +routes
cd base-routes
npm install
lein prod
cd resources/public
google-chrome index.html
cd ../../..

printf "\ncreating base +re-com\n"
lein new re-frame base-recom +re-com
cd base-recom
npm install
lein prod
cd resources/public
google-chrome index.html
cd ../../..

printf "\ncreating base +routes +re-com\n"
lein new re-frame base-routes-recom +routes +re-com
cd base-routes-recom
npm install
lein prod
cd resources/public
google-chrome index.html
cd ../../..

printf "\ncreating base +cider +routes +re-com +test +garden +handler +less +re-frisk +10x +re-pressed +breaking-point +shadow-cljs\n"
lein new re-frame everything +cider +routes +re-com +test +garden +handler +less +re-frisk +10x +re-pressed +breaking-point
cd everything
npm install
lein prod
npm install -g karma-cli
lein run -m shadow.cljs.devtools.cli compile karma-test
cd resources/public
google-chrome index.html

cd ../../..
