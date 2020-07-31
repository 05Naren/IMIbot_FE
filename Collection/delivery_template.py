if 'store_name' in variables['newdfState']['model_state']['entities'] and variables['newdfState']['model_state']['entities']['store_name'] is not None:
    location = variables['newdfState']['model_state']['entities']['store_name']['value']
    output = {"generated_msg": [
        {"include": ['web'], 'text': ["yes we deliver to "+ str(location)]}]}
else:
    output = {"generated_msg": [
        {"include": ['web'], 'text': ["Please enter from where you want delivery"]}]}