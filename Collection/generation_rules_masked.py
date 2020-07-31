if variables.get('detected_language')=='en':
  templateKey = "en"
  messageStore = {"endflow": False}
elif variables.get('detected_language')=='fr':
  templateKey = "fr"
  messageStore = {"endflow": False}
elif 'newdfState' in variables and variables['newdfState'] and variables['newdfState']['greeting']=='single_match':
  templateKey = "A1"
  messageStore = {"endflow": False, "concept_sensitive":True}
elif 'newdfState' in variables and variables['newdfState'] and variables['newdfState']['greeting']=='double':
  templateKey = "A2"
  messageStore = {"endflow": False, "concept_sensitive":True}
elif 'newdfState' in variables and variables['newdfState'] and variables['newdfState']['greeting']=='creditcard_regex':
  templateKey = "A3"
  messageStore = {"endflow": False, "concept_sensitive":True}
else:
  templateKey = "else"
  messageStore = {"endflow": False}

output = {
  "templateKey": templateKey,
  "messageStore": messageStore
}