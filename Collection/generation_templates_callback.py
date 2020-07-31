if(variables['templateKey'] == 'A1'):
  output = [
    {"text": ["You will experience " + str(variables["dataStore"]["weatherData"]["description"]) + " in " + variables["dataStore"]["city"] + ". The temperature will be " + variables["dataStore"]["weatherData"]["temperature"] + ". Humidity will be " + variables["dataStore"]["weatherData"]["humidity"] + ". There will be " + variables["dataStore"]["weatherData"]["cloudiness"] + " cloudiness. Wind speed would be " + variables["dataStore"]["weatherData"]["windspeed"] + ". This report is dated " + variables["dataStore"]["weatherData"]["reporttime"]]}
  ]
elif(variables['templateKey'] == 'child_bot'):
  output = [{"include": ["facebook", "web",'skype'],
                   "text": [
                       variables['dataStore']['response']]}
                  ]
else:#if(variables['templateKey'] == 'A2'):
  output = [{"include": ["facebook", "web",'skype'],
                   "text": [
                       "Default"]}
                  ]