if(variables['templateKey'] == 'A1'):
  output = [
    {"text": ["You will experience " + str(variables["dataStore"]["weatherData"]["description"]) + " in " + variables["dataStore"]["city"] + ". The temperature will be " + variables["dataStore"]["weatherData"]["temperature"] + ". Humidity will be " + variables["dataStore"]["weatherData"]["humidity"] + ". There will be " + variables["dataStore"]["weatherData"]["cloudiness"] + " cloudiness. Wind speed would be " + variables["dataStore"]["weatherData"]["windspeed"] + ". This report is dated " + variables["dataStore"]["weatherData"]["reporttime"]]}
  ]
elif(variables['templateKey'] == 'A2'):
  output = [{"text":["I was not able to get a city name. Could you please try again, please.","I am not able to capture city name. Try me once more?"]}]