cd scripts
rm ../lambda/index.js
cp ../index.js ../lambda/
rm -R ../lambda/node_modules
mkdir ../lambda/node_modules
mv -v ../node_modules/ask-sdk-core ../lambda/node_modules/ask-sdk-core
mv -v ../node_modules/ask-sdk-model ../lambda/node_modules/ask-sdk-model
mv -v ../node_modules/ask-sdk-runtime ../lambda/node_modules/ask-sdk-runtime