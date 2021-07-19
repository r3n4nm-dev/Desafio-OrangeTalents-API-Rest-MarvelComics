# Desafio-OrangeTalents-API-Rest-MarvelComics
Desafio Orange Talents

A.) CONTEXTO:
Você está fazendo uma API REST que precisará gerenciar Comics (Livros) de usuários.

O primeiro passo deve ser a construção de um cadastro de usuários, sendo obrigatórios os dados: nome, e-mail, CPF e data de nascimento, sendo que e-mail e CPF devem ser únicos.

O segundo passo é criar um cadastro de Comics (Livros), sendo obrigatório a API desenvolvida salvar os dados: ComicId, Título, Preço, Autores, o ISBN e Descrição. Sendo que o serviço deve consumir a API da MARVEL (https://developer.marvel.com/) para buscar os dados do Comics baseado no ComicId informado.

O terceiro passo é criar um endpoint que retornará um usuário com a lista de todos seus Comics (Livros) cadastrados.

Você deve construir 3 endpoints neste sistema, o cadastro do usuário, o cadastro de comics e a listagem dos comics para um usuário específico.

No endpoint que irá listar os comics (o terceiro), devemos considerar algumas configurações a serem exibidas para o usuário final. Vamos criar dois novos atributos no objeto do Comics, sendo eles:

1.) Dia do desconto deste Comics, baseado no último número do ISBN do comics, considerando as condicionais:
Final 0-1: segunda-feira
Final 2-3: terça-feira
Final 4-5: quarta-feira
Final 6-7: quinta-feira
Final 8-9: sexta-feira

2.) Também devemos criar um atributo de desconto ativo, onde nós devemos pegar a data atual do sistema e comparar com as condicionais anteriores, onde, quando for o dia ativo do desconto retornar true, caso contrário, false.

Exemplo A: hoje é segunda-feira, o Comics tem o ISBN XXXXXXXX1, ou seja, seu desconto será às segundas-feiras e o atributo de desconto ativo será TRUE.
Exemplo B: hoje é quinta-feira, o Comics tem o ISBN XXXXXXXX1, ou seja, seu desconto será às segundas-feiras e o atributo de desconto ativo será FALSE.

3.) Caso seja o dia de desconto do livro, o preço a ser exibido deve aparecer com 10% a menos que o valor retornado pela API da MARVEL.

STATUS
- Caso os cadastros estejam corretos, é necessário voltar o Status 201. Caso hajam erros de preenchimento de dados, o Status deve ser 400.
- Caso a busca esteja correta, é necessário voltar o Status 200. Caso haja erro na busca, retornar o status adequado e uma mensagem de erro amigável.


D.) ITEM BÔNUS - Se ficou fácil, te desafiamos a:

    Desafiamos você a construir a aplicação sem utilizar Lombok;

    Desafiamos você a integrar a API da MARVEL usando Spring-Cloud-Feign.
