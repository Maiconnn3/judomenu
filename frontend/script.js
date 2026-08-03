const urlJudoSys = "http://localhost:8080/judocas";


const tabs = document.querySelectorAll('.botaoTab');
tabs.forEach(tab => tab.addEventListener('click', () => tabClicada(tab)));

function tabClicada(tab) {
    tabs.forEach(tab => tab.classList.remove('active'));
    tab.classList.add('active');

    const conteudos = document.querySelectorAll('.conteudo');
    conteudos.forEach(conteudo => conteudo.classList.remove('show'));

    const conteudoId = tab.getAttribute('content-id');
    const conteudo = document.getElementById(conteudoId);

    conteudo.classList.add('show');
}


async function criarJudoca(){
    try {
        const nomeRecebido = document.getElementById("nome").value;
        const idadeRecebida = parseInt(document.getElementById("idade").value);
        const pesoRecebido = parseFloat(document.getElementById("peso").value);
        const faixaRecebida = parseInt(document.getElementById("faixa").value);

        const novoJudoca = {
            nome: nomeRecebido,
            idade: idadeRecebida,
            peso: pesoRecebido,
            faixa: {
                id: faixaRecebida
            }
        };

        const resposta = await fetch(urlJudoSys, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(novoJudoca)
        });

        if(resposta.ok){
            alert("Judoca matriculado com sucesso!");
        } else{
            alert("Erro ao matricular.");
        }

    } catch (error) {

    }
}


 async function buscarJudocas(){
    try {
        const resposta = await fetch(urlJudoSys);
        const elementoId = document.getElementById("listaHTML");
        const listaJudocas = await resposta.json();

        elementoId.innerHTML = "";

        listaJudocas.forEach(judoca => {
            elementoId.innerHTML += 
            "<li>Nome: " + judoca.nome + 
            " | Idade: " + judoca.idade +
            " | Peso: " + judoca.peso +
            " | Faixa: " + judoca.faixa.id +
            "</li>";
        });

        console.log(listaJudocas);

    } catch (error) {
        console.log(error.message);
    }
}


async function buscarPorId(){
    try{
        const idBusca = document.getElementById("inputBuscarId").value;
        const dadosJudoca = await fetch(urlJudoSys + "/" + idBusca);
        const dadosJudocaJSON = await dadosJudoca.json();
        const elementoId = document.getElementById("listaHTML");
        
        elementoId.innerHTML = "";

        elementoId.innerHTML +=
        "<li>Nome: " + dadosJudocaJSON.nome + 
        " | Idade: " + dadosJudocaJSON.idade +
        " | Peso: " + dadosJudocaJSON.peso +
        " | Faixa: " + dadosJudocaJSON.faixa.id +
        "</li>";

    } catch (error) {
        alert("ID não encontrado!");
        console.log(error.message);
    }
}


async function atualizarPorId(){
    try{
        const idUpdate = document.getElementById("idUpdatePorId").value;
        const nomeRecebido = document.getElementById("nomeUpdate").value;
        const idadeRecebida = parseInt(document.getElementById("idadeUpdate").value);
        const pesoRecebido = parseFloat(document.getElementById("pesoUpdate").value);
        const faixaRecebida = parseInt(document.getElementById("faixaUpdate").value);

        const judocaAtualizado = {
            nome: nomeRecebido,
            idade: idadeRecebida,
            peso: pesoRecebido,
            faixa: {
                id: faixaRecebida
            }
        };

        const resposta = await fetch(urlJudoSys + "/" + idUpdate, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(judocaAtualizado)
        });

    } catch(error) {
        alert("ID não encontrado!");
        console.log(error.message);
    }
}


async function deletarPorId(){
    try{
        const idDelete = document.getElementById("inputDeletarPorId").value;

        const resposta = await fetch(urlJudoSys + "/" + idDelete, {
            method: "DELETE"
        });

        if (resposta.ok) {
            alert("Judoca excluído com sucesso!");
        } else{
            alert("Erro");
        }
    } catch (error) {
        alert("ID não encontrado!");
        console.log(error.message);
    } 
}

