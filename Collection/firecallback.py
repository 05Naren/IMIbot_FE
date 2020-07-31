import requests
headers = {"Content-Type": "application/json"}
url = "https://hooks.imiconnect.io/events/6PEJZS8B9O" 
body={ 
    "callback_id": "123",
    "data_payload": {"roomid": variables['nlp']['room_id'],
    "user_message": variables['nlp']['text']},
    "callback_type": "callback"}
fireevent(url=url, data=body, method="POST", headers=headers)
output={ 
    "responseflag" : True,
    "generated_msg":[{"text":["invoked callback"]}],
    "dataStore":{
        "flowstate":"async triggered"
    },
}