#!/bin/bash

rm -r temp
mkdir temp
cd temp

printf "\ncreating base\n"
lein new re-frame base
cd base
npm install
npm run release
cd resources/public
google-chrome --headless --disable-gpu index.html || chromium --headless --disable-gpu index.html 
cd ../../..

printf "\ncreating base +routes\n"
lein new re-frame base-routes +routes
cd base-routes
npm install
npm run release
cd resources/public
google-chrome --headless --disable-gpu index.html || chromium --headless --disable-gpu index.html 
cd ../../..

printf "\ncreating base +re-com\n"
lein new re-frame base-recom +re-com
cd base-recom
npm install
npm run release
cd resources/public
google-chrome --headless --disable-gpu index.html || chromium --headless --disable-gpu index.html 
cd ../../..

printf "\ncreating base +routes +re-com\n"
lein new re-frame base-routes-recom +routes +re-com
cd base-routes-recom
npm install
npm run release
cd resources/public
google-chrome --headless --disable-gpu index.html || chromium --headless --disable-gpu index.html 
cd ../../..

printf "\ncreating base +10x +breaking-point +cider +garden +handler +kondo +re-com +re-frisk +re-pressed +routes +test +github-actions\n"
lein new re-frame everything +10x +breaking-point +cider +garden +git-inject +kondo +re-com +re-frisk +re-pressed +routes +test +github-actions
cd everything
npm install
npm run release
npm run ci
cd resources/public
google-chrome --headless --disable-gpu index.html || chromium --headless --disable-gpu index.html 

cd ../../..
