templateKey = ""

messageStore = {}

if(variables['newdfState']['city']):
  templateKey = "A1"
  messageStore = {
    "endflow":True
  }
else:
  import requests
  url = "https://preprod.imibot.ai/send"
  data = {"msg": variables['nlp']['actual_text'],
          "transaction_id":variables['transaction_id'],
        "platform": "web",
        "type": "human",
        "managerBotRoomId": int(str(variables['nlp']['room_id'])),
        "consumer": variables["consumerData"]}
  headers = {
    'Content-Type': "application/json",
    'x-access-token': "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6NTM0LCJyb2xlIjoiYm90In0.cSqavgKXeRtLT5ecqDLg3lwC9ZVLAQFORZS73M4C1CI"
    }
  response = requests.request("POST", url, json=data, headers=headers)
  response_json = response.json()
  templateKey = 'child_bot'
  try:
    response = response_json['generated_msg'][0]['text']
  except:
    response = ''
  variables['dataStore']['response'] = response
  messageStore = {
    "endflow": False,
    "sendtoagent": response_json['sendtoagent']
  }

output = {
  "templateKey": templateKey,
  "dataStore":variables['dataStore'],
  "messageStore": messageStore
}
