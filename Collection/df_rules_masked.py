newdf = {}
if 'nlp' in variables and 'custom_ners' in variables['nlp'] and 'single_match' in variables['nlp']['custom_ners']:
  newdf = {
  "greeting": "single_match"
  }

elif 'nlp' in variables and 'custom_ners' in variables['nlp'] and 'double' in variables['nlp']['custom_ners']:
  newdf = {
  "greeting": "double"
  }

elif 'nlp' in variables and 'custom_ners' in variables['nlp'] and 'creditcard_regex' in variables['nlp']['custom_ners']:
  newdf = {
  "greeting": "creditcard_regex"
  }
else:
  newdf = {
  "greeting": ""
  }

output = {
  "df": newdf
}