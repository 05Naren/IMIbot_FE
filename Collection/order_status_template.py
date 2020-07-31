if 'order_id' in variables['newdfState']['model_state']['entities'] and variables['newdfState']['model_state']['entities']['order_id'] is not None:
    trc_order_id = variables['newdfState']['model_state']['entities']['order_id']['value']
    output = {"generated_msg": [
        {"include": ['web'], 'text': ["Order with ORDER ID - " +str(trc_order_id)+" will be delivered in 72hrs"]}]}
else:
    output = {"generated_msg": [
        {"include": ['web'], 'text': ["Please enter a valid order id"]}]}