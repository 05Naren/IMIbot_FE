if 'city name' in variables['newdfState']['model_state']['entities'] and variables['newdfState']['model_state']['entities']['city name'] is not None:
    #location = variables['newdfState']['model_state']['entities']['store_name']['value']
    output = {"generated_msg": [
        {"include": ['web'], 'text': ["***************"]}]}
else:
    output = {"generated_msg": [
        {"include": ['web'], 'text': ["Please provide the city name"]}]}