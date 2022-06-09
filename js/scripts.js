/*!
* Start Bootstrap - Freelancer v7.0.6 (https://startbootstrap.com/theme/freelancer)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-freelancer/blob/master/LICENSE)
*/
//
// Scripts
// metodo pro post
function fazPost(url, body) {
    console.log("Body=", body)
    let request = new XMLHttpRequest()
    request.open("POST", url, true)
    request.setRequestHeader("Content-type", "application/json")
    request.send(JSON.stringify(body))

    request.onload = function() {
        console.log(this.responseText)
    }

    return request.responseText
}



function fetchApiData(){
    const cpfarea = document.getElementById('cpf_textarea').value;
    const api = `http://localhost:8085/api/alunos/${cpfarea}`
    fetch(api).then(response =>  response.json())
    .then(data => {
        const table = document.querySelector('table_alunos');
        const linha = document.querySelector('linha_alunos')
        
            data = new Array(data)
            let tabela = document.getElementById("table_alunos")
            for (let aluno of data)  {
                let linha = criaLinha(aluno);
                tabela.appendChild(linha);
            }
            
                

            
            
    }
    )
}


//metodos para cadastros

function cadastraUsuario() {
    event.preventDefault()
    let url = "http://localhost:8085/api/alunos"
    let nome = document.getElementById("nome").value
    let email = document.getElementById("email").value
    let telefone = document.getElementById("telefone").value
    let cpf = document.getElementById("cpf").value
    console.log(nome)
    console.log(email)
    console.log(telefone)
    console.log(cpf)

    body = {
        "nome": nome,
        "email": email,
        "telefone": telefone,
        "cpf": cpf
    }

    fazPost(url, body)

    nome.value = ''
    email.value = ''
    telefone.value = ''
    cpf.value = ''
}

//metodos para cadastros
function cadastraLivro() {
    event.preventDefault()
    let url = "http://localhost:8085/api/livros"
    let codigo = document.getElementById("codigo").value
    let titulo = document.getElementById("titulo").value
    let autor = document.getElementById("autor").value
    let datacompra = document.getElementById("datacompra").value
    console.log(codigo)
    console.log(titulo)
    console.log(autor)
    console.log(datacompra)

    body = {
        "codigo": codigo,
        "titulo": titulo,
        "autor": autor,
        "datacompra": datacompra
    }

    fazPost(url, body)

 
}



function limpar(){
    codigo.value = ''
    titulo.value = ''
    autor.value = ''
    datacompra.value = ''
}

function popup(){
    alert("Usuario cadastrado com sucesso");
}


function criaLinha(data) {
    linha = document.createElement("tr");
    tdId = document.createElement("td");
    tdNome = document.createElement("td");
    tdEmail = document.createElement("td");
    tdTelefone = document.createElement("td");
    tdId.innerHTML = data.cpf;
    tdNome.innerHTML = data.nome;
    tdEmail.innerHTML = data.email;
    tdTelefone.innerHTML = data.telefone;

    linha.appendChild(tdId);
    linha.appendChild(tdNome);
    linha.appendChild(tdEmail);
    linha.appendChild(tdTelefone);

    return linha;
}

