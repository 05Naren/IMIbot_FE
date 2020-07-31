import requests

if('city' in variables['nlp']['custom_ners']):
  city = variables['nlp']['custom_ners']['city_value'][0]

  r=requests.get("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&APPID=f868d20e6773ade1d5f031c453c4b1b5")
  answer = r.json()

  def convertKelvinsToCelcius(temp):
    if(temp):
      return format(float(temp)-273.15,".2f")
    else:
      return 0.0

  if(answer):
    dataStore={
      "city": answer['city']['name'],
      "weatherData": {
        "description": answer['list'][0]['weather'][0]['description'],
        "temperature": str(convertKelvinsToCelcius(answer['list'][0]['main']['temp'])) + " degrees celcius",
        "humidity": str(answer['list'][0]['main']['humidity']),
        "cloudiness": str(answer['list'][0]['clouds']['all']) + "%",
        "windspeed": str(answer['list'][0]['wind']['speed']) + "m/sec",
        "reporttime": str(answer['list'][0]['dt_txt'])
      }
    }
  else:
    dataStore=variables['dataStore']
else:
  city=None
  dataStore=None

newdf = {
  "city": city
}

output = {
  "df": newdf,
  "dataStore": dataStore
}