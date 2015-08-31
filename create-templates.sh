#!/bin/bash

rm -r temp
mkdir temp
cd temp

echo creating base
lein new re-frame base
cd base
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..


echo creating base +routes
lein new re-frame base-routes +routes
cd base-routes
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..

echo creating base +re-com
lein new re-frame base-recom +re-com
cd base-recom
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..

echo creating base +test
lein new re-frame base-test +test
cd base-test
lein cljsbuild once min
lein cljsbuild once test
cd resources/public
google-chrome index.html
cd ../../..

echo creating base +garden
lein new re-frame base-garden +garden
cd base-garden
lein garden once
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..


echo creating base +routes +re-com
lein new re-frame base-routes-recom +routes +re-com
cd base-routes-recom
lein cljsbuild once min
cd resources/public
google-chrome index.html
cd ../../..


echo creating base +routes +re-com +test +garden
lein new re-frame everything +routes +re-com +test +garden
cd everything
lein garden once
lein cljsbuild once min
lein cljsbuild once test
cd resources/public
google-chrome index.html
cd ../../..
