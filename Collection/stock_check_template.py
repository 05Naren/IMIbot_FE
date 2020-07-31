if 'product_names' in variables['newdfState']['model_state']['entities'] and variables['newdfState']['model_state']['entities']['product_names'] is not None:
    product_name = variables['newdfState']['model_state']['entities']['product_names']['value']
    if 'store_name' in variables['newdfState']['model_state']['entities'] and variables['newdfState']['model_state']['entities']['store_name'] is not None:
        store_name = variables['newdfState']['model_state']['entities']['store_name']['value']
        output = {"generated_msg": [
        	{"include": ['web'], 'text': ["Yes, Product Name : "+str(product_name)+" is availabe in store : "+str(store_name)]}]}
    else:
        output = {"generated_msg": [
            {"include": ['web'],'text': ["Please enter the store Name"]}]}
else:
    output = {"generated_msg": [
        {"include": ['web'], 'text': ["Please enter a product name"]}]}