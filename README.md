# API com Spring Boot

***Link para o Heroku***: https://floating-mountain-94318.herokuapp.com/

Para se ter acesso aos dados da API é necessário a sua autenticação e para consegui-la tem que
enviar uma requisição POST para a URL https://floating-mountain-94318.herokuapp.com/login em formato JSON
com o username e password.

Então para conseguir sua autenticação nas outras partes do sistema sempre mande no header o seu token obtido 
no login. 

Para se ter acesso aos complexos eolicos mande as suas requisições para a URL:
https://floating-mountain-94318.herokuapp.com/complexo_eolico

Para se ter acesso aos parques eolicos mande as suas requisições para a URL:
https://floating-mountain-94318.herokuapp.com/complexo_eolico/{complexo_id}/parque_eolico

E por fim para se ter acesso aos aegerador mande-as para URL:
https://floating-mountain-94318.herokuapp.com/complexo_eolico/{complexo_id}/parque_eolico/{paque_id}/aerogerador