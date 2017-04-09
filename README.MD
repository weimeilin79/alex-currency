alexa-currency-change
==================

[Amazon Alexa](http://alexa.amazon.com/spa/index.html) custom skill to perform functions against [OpenShift Online Developer Preview](https://www.openshift.com/devpreview/)

## Example Commands

* Alexa, ask robot, What is the currency rate for {AMOUNT} in {CURRENCYTO}

_The amount in USD is_




## Setup

1. Create an Alexa Skill over the Developer Console
2. Use the [IntentSchema.json](speechAssets/IntentSchema.json) to define the intent schema and define currency in 
Custom Slot Types 
3. Use the [SampleUtterances.txt](speechAssets/SampleUtterances.txt) file to the define the utterances
4. Configure values in the Lambda

   - ALEXA_APP_ID
   - THREESCALE_API_TOKEN
   - BASE_URL

5. Build the project into a single jar with all of the dependencies included and upload as a Lambda function

	```
	mvn clean assembly:assembly -DdescriptorId=jar-with-dependencies package
	```

5. Define "Alexa Skill Kit" as the Lambda's event source
6. Set the ARN of this Lambda function as your skill's endpoint


