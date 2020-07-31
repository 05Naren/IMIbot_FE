templateKey = ""

messageStore = {}

if(variables['newdfState']['city']):
  templateKey = "A1"
  messageStore = {
    "endflow":True
  }
else:
  templateKey = "A2"
  messageStore = {
    "endflow": False
  }

output = {
  "templateKey": templateKey,
  "messageStore": messageStore
}
