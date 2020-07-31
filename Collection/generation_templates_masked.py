if(variables['templateKey'] == 'A1'):
  output = [{"include":["web"],"text":["Hi,this is concept sensitive single match"]}]
if(variables['templateKey'] == 'A2'):
  output = [{"include":["web"],"text":["Hi,this is concept sensitive double match"]}]
if(variables['templateKey'] == 'A3'):
  output = [{"include":["web"],"text":["Hi,credit card number is masked"]}]
if(variables['templateKey'] == 'en'):
  output = [{"include":["web"],"text":["english detected"]}]
if(variables['templateKey'] == 'fr'):
  output = [{"include":["web"],"text":["french detected"]}]
  
if(variables['templateKey'] == 'else'):
  output = [{"include":["web"],"text":["else"]}]