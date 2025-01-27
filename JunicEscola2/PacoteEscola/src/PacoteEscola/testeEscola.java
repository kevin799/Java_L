﻿package PacoteEscola;
import static org.junit.Assert.*;
import org.junit.Test;
public class testeEscola {

	@Test
	public void test() {
		
		Escola_Modelo escola_modelo = new Escola_Modelo();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//############ALUNO############
		//############CADASTRO DE ALUNO NA CLASSE############
		//Cadastra um aluno
		escola_modelo.cadastrarAluno(new Aluno(123,321,999,"teste@teste.com", "nome do meu pai", "nome da minha mae", "Nome do aluno",false));	
		escola_modelo.cadastrarAluno(new Aluno(123456789,12354698,9215496,"joaoPedro@email.com", "Jose", "Maria", "Joao_Pedro",true));	
		escola_modelo.cadastrarAluno(new Aluno(123987456,14785236,9956847,"mariaA@email.com", "Paulo", "Ellen", "Maria_Almeida",false));	
		escola_modelo.cadastrarAluno(new Aluno(123456789,12354698,9215496,"joaoPedro@email.com", "Jose", "Maria", "Joao_Pedro",false));	//Nao registra,cadastro repetido

		//############CADASTRO COM DADOS INCOMPLETOS############
		//CADASTRAR ALUNO COM CPF, EMAIL, NOME
		//escola_modelo.cadastrarAluno(new Aluno(1233332,"teste2@teste.com", "Nome do aluno 2"));

		//CADASTRAR ALUNO COM SOMENTE CPF, RA E NOME
		//escola_modelo.cadastrarAluno(new Aluno(3213,1233, "Nome do aluno 3"));
		
		//CADASTRAR ALUNO SOMENTE COM CPF
		//CONSTA COMO ALUNO JA CADASTRADO
		//escola_modelo.cadastrarAluno(new Aluno(4878));
		
		////////////////////////////////////Testes adicionais/////////////////////////////////////////
		
		assertEquals(escola_modelo.getAlunos().size(),3); //Conta quantos alunos estao cadastrados
		
		assertEquals(escola_modelo.buscarAlunoPorCPF(123).size(),1); //retorna a quantidade de alunos com este cpf
		assertEquals(escola_modelo.buscarAlunoPorCPF(123456789).size(),1);
		assertEquals(escola_modelo.buscarAlunoPorCPF(123987456).size(),1);
		
		assertEquals(escola_modelo.buscarAlunoPorRa(12354698).size(),1);//retorna a quantidade de alunos com este ra
		assertEquals(escola_modelo.buscarAlunoPorRa(321).size(),1);
		assertEquals(escola_modelo.buscarAlunoPorRa(14785236).size(),1);
		//assertEquals(escola_modelo.buscarAlunoPorRa(1475236).size(),1); // Da erro pq nao há pessoa com este ra
		
		
		assertEquals(escola_modelo.trancarMateria(escola_modelo.getAlunos().get(1).getcpf(),escola_modelo.getAlunos().get(1).getra(), escola_modelo.getAlunos().get(1).getNome_aluno(),escola_modelo.getAlunos().get(1).getMatricula()),false); //vai retornar false por que o aluno já esta com a matricula trancada
		assertEquals(escola_modelo.trancarMateria(escola_modelo.getAlunos().get(2).getcpf(),escola_modelo.getAlunos().get(2).getra(), escola_modelo.getAlunos().get(2).getNome_aluno(),escola_modelo.getAlunos().get(2).getMatricula()),true);  //vai retornar true por que o aluno nao esta com a matricula trancada
		
		assertEquals(escola_modelo.buscarNomeAlunoporRa(escola_modelo.getAlunos().get(1).getra()),new String ("Joao_Pedro"));
		assertEquals(escola_modelo.buscarNomeAlunoporRa(escola_modelo.getAlunos().get(2).getra()),new String ("Maria_Almeida"));
		//assertEquals(escola_modelo.buscarNomeAlunoporRa(escola_modelo.getAlunos().get(2).getra()),new String ("Maria_Almeid")); //Vai dar erro pq nao existe "Maria_Almeid" cadastradp

		assertEquals(escola_modelo.RealizarMatricula(escola_modelo.getAlunos().get(1).getcpf(),escola_modelo.getAlunos().get(1).getra(), escola_modelo.getAlunos().get(1).getNome_aluno(),escola_modelo.getAlunos().get(1).getMatricula()),true); //vai retornar true por que o aluno estava com matricula trancada
		assertEquals(escola_modelo.RealizarMatricula(escola_modelo.getAlunos().get(2).getcpf(),escola_modelo.getAlunos().get(2).getra(), escola_modelo.getAlunos().get(2).getNome_aluno(),escola_modelo.getAlunos().get(2).getMatricula()),false);  //vai retornar false por que o aluno ja esta matriculado
	
		
		///////////////////////////////////////////////////////////////////////////
		//ARRUMAR
		//CADASTRAR ALUNO SEM RESPONSAVEIS
		//escola_modelo.cadastrarAluno(new Aluno(1235,3215,9995,"teste5@teste.com", "Nome do aluno 5"));
		
		
		
		//CONSTA COMO ALUNO JA CADASTRADO
		//CADASTRAR ALUNO COM SOMENTE CPF E NOME
		//escola_modelo.cadastrarAluno(new Aluno(1236, "Nome do aluno 6"));
		
		//############PESQUISAS DE VARIAVEIS SEPARADAS############
		
		//Verificar a quantidade de itens cadastrados
		//assertEquals(escola_modelo.pesquisarAluno().size(), 1);
		
		//PESQUISAR ALUNO POR NOME
		//assertEquals(escola_modelo.getAlunos().get(0).getNome_aluno(), "Nome do aluno");
		
		//PESQUISA POR TELEFONE
		//assertEquals(escola_modelo.getAlunos().get(0).getTelefone(), 999);
		
		//PESQUISA DE ALUNO POR CPF
		//assertEquals(escola_modelo.getAlunos().get(0).getcpf(), 123);
		
		//PESQUISAR ALUNO POR NOME PAI
		//assertEquals(escola_modelo.getAlunos().get(0).getNome_pai(), "nome do meu pai");

		//PESQUISAR ALUNO POR MAE
		//assertEquals(escola_modelo.getAlunos().get(0).getNome_mae(), "nome da minha mae");
		
		//PESQUISAR ALUNO POR RA
		//assertEquals(escola_modelo.getAlunos().get(0).getra(), 321);
		
		//PESQUISAR ALUNO POR EMAIL
		//assertEquals(escola_modelo.getAlunos().get(0).getEmail(), "teste@teste.com");
		
		//############TESTES DE PESQUISAS COM DADOS DIFERENTES############
		
		//PESQUISAR POR ALUNO COM DIFEREN�A DE DIGITACAO
		//assertEquals(escola_modelo.getAlunos().get(0).getNome_aluno(), "NOME DO ALUNO 1");
		
		//PESQUISAR POR CPF COM DIFEREN�A DE DIGITACAO
		//assertEquals(escola_modelo.getAlunos().get(0).getcpf(), "um");
		
		//PESQUISAR POR MAE COM DIFEREN�A DE DIGITACAO
		//assertEquals(escola_modelo.getAlunos().get(0).getNome_mae(), "maira1");
		
		//PESQUISAR POR PAI COM DIFEREN�A DE DIGITACAO
		//assertEquals(escola_modelo.getAlunos().get(0).getNome_pai(), "pai10");
		
		//PESQUISAR POR EMAIL COM DIFEREN�A DE DIGITACAO
		//assertEquals(escola_modelo.getAlunos().get(0).getEmail(), "teste@");
		
		//############TESTES COM CADASTRO DUPLICADO E FALSO POSITIVO############
		//OBJETO TESTE PARA CRIACAO REPETIDA DE USUARIO TESTANDO CADASTRO REPETIDO (EMAIL, CPF, RA)
		//escola_modelo.cadastrarAluno(new Aluno(123,321,999,"teste@teste.com", "nome do meu pai", "nome da minha mae", "Nome do aluno"));
		
		//RESULTADO FALSO DE TESTE ASSERTEQUALS COM DOIS ALUNOS
		//assertEquals(escola_modelo.pesquisarAluno().size(), 2);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//############FUNCIONARIO############
		//############CADASTRO DE FUNCIONARIO############
		//CADASTRAR FUNCIONARIO
		escola_modelo.cadastrarFuncionario(new Funcionario(123,321,99999999,"NOME DO FUNCIONARIO", "RUA FUNCIONARIO", "PERIODO FUNCIONARIO", "SETOR FUNCIONARIO", "CARGO FUNCIONARIO"));
		
		
		//############CADASTRO COM DADOS INCOMPLETOS############
		//CADASTRO COM SOMENTE NOME E CPF
		//escola_modelo.cadastrarFuncionario(new Funcionario(999999991,"NOME DO FUNCIONARIO 1"));
		
		//CADASTRO SEM INFORMACOES DE CARGO
		//escola_modelo.cadastrarFuncionario(new Funcionario(1232,3212,999999992,"NOME DO FUNCIONARIO 2", "RUA FUNCIONARIO 2"));
		
		//CADASTRO SEM ENDERECO E TELEFONE
		//escola_modelo.cadastrarFuncionario(new Funcionario(1233,3213,"NOME DO FUNCIONARIO 3", "PERIODO FUNCIONARIO 3", "SETOR FUNCIONARIO 3", "CARGO FUNCIONARIO 3"));
		
		//CADASTRO SEM ID
		//escola_modelo.cadastrarFuncionario(new Funcionario(321,999999994,"NOME DO FUNCIONARIO 4", "RUA FUNCIONARIO 4", "PERIODO FUNCIONARIO 4", "SETOR FUNCIONARIO 4", "CARGO FUNCIONARIO 4"));
		
		//CADASTRO SEM CPF E TELEFONE
		//escola_modelo.cadastrarFuncionario(new Funcionario(1235,"NOME DO FUNCIONARIO 5", "RUA FUNCIONARIO 5", "PERIODO FUNCIONARIO 5", "SETOR FUNCIONARIO 5", "CARGO FUNCIONARIO 5"));
		
		//////////////////////Teste adicional/////////////////////////////
		
		escola_modelo.cadastrarFuncionario(new Funcionario(1234,3214,99999997,"Maria", "RUA FUNCIONARIO x", "PERIODO FUNCIONARIO n", "SETOR FUNCIONARIO x", "CARGO FUNCIONARIO x"));
		escola_modelo.cadastrarFuncionario(new Funcionario(1235,3215,99999998,"Jonel", "RUA FUNCIONARIO y", "PERIODO FUNCIONARIO m", "SETOR FUNCIONARIO y", "CARGO FUNCIONARIO y"));
		escola_modelo.cadastrarFuncionario(new Funcionario(1234,3214,99999997,"Maria", "RUA FUNCIONARIO x", "PERIODO FUNCIONARIO n", "SETOR FUNCIONARIO x", "CARGO FUNCIONARIO x"));
		
		assertEquals(escola_modelo.buscarFuncionarioPorCPF(3214).size(),1); //Mesmo com cadstro repetido encontra somente 1 funcionario com este cpf
		assertEquals(escola_modelo.buscarFuncionarioPorCPF(3215).size(),1);
		
		
		//////////////////////////////////////////////////////////////////
		//############PESQUISAS DE VARIAVEIS SEPARADAS############
		//Pesquisar por CPF
		//assertEquals(escola_modelo.pesquisarFuncionario().get(0).getCpf(), 321);
		
		//Pesquisar por Telefone
		//assertEquals(escola_modelo.pesquisarFuncionario().get(0).getTelefone(), 99999999);
		
		//Pesquisar por Endere�o
		//assertEquals(escola_modelo.pesquisarFuncionario().get(0).getEndereco(), "RUA FUNCIONARIO");
		
		//Pesquisar por Periodo
		//assertEquals(escola_modelo.pesquisarFuncionario().get(0).getPeriodo(), "PERIODO FUNCIONARIO");
		
		//Pesquisar por Cargo
		//assertEquals(escola_modelo.pesquisarFuncionario().get(0).getCargo(), "CARGO FUNCIONARIO");

		//############PESQUISAS COM DADOS DIFERENTES############
		//PESQUISAR POR CPF COM DIFEREN�A DE DIGITACAO
		//assertEquals(escola_modelo.pesquisarFuncionario().get(0).getCpf(), "321a");
		
		//PESQUISAR POR TELEFONE COM DIFEREN�A DE DIGITACAO
		//assertEquals(escola_modelo.pesquisarFuncionario().get(0).getTelefone(), "a99999999");
		
		//PESQUISAR POR ENDERECO COM DIFEREN�A DE DIGITACAO
		//assertEquals(escola_modelo.pesquisarFuncionario().get(0).getEndereco(), "Rua fUNCIONARIO1");
		
		//PESQUISAR POR PERIODO COM DIFEREN�A DE DIGITACAO
		//assertEquals(escola_modelo.pesquisarFuncionario().get(0).getPeriodo(), "Periodo F1cionario");
		
		//PESQUISAR POR CARGO COM DIFEREN�A DE DIGITACAO
		//assertEquals(escola_modelo.pesquisarFuncionario().get(0).getCargo(), "Cargo FUNCIONARIO");
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		//############Curso############
		//############CADASTRO DE ALUNO NA CLASSE###############
		//CADASTRAR CURSO
		escola_modelo.cadastrarCurso(new Curso("Banco de Dados","Noturno",1));
		
		//############CADASTRO COM DADOS INCOMPLETOS############
		//CADASTRO SEM NOME
		//escola_modelo.cadastrarCurso(new Curso("Manha1",11));
		
		//CADASTRO SEM PERIODO
		//escola_modelo.cadastrarCurso(new Curso("Banco de Dados 2",21));
		
		//CADASTRO SEM ID
		//escola_modelo.cadastrarCurso(new Curso("Banco de Dados 3","Noturno3"));
		
		//############PESQUISAS DE VARIAVEIS SEPARADAS##########
		//TESTAR CURSO CADASTRADO
		//assertEquals(escola_modelo.pesquisarCurso().size(), 1);
		
		//PESQUISAR POR NOME
		//assertEquals(escola_modelo.pesquisarCurso().get(0).getNome_curso(), "Banco de Dados");
		
		//PESQUISAR POR PERIODO
		//assertEquals(escola_modelo.pesquisarCurso().get(0).getPeriodo(), "Noturno");
		
		//PESQUISAR POR ID
		assertEquals(escola_modelo.pesquisarCurso().get(0).getId(), 1);
		
		//////////////////////TESTE ADICIONAL////////////////////////////
		
		escola_modelo.cadastrarCurso(new Curso("ADS","Manha",2));
		escola_modelo.cadastrarCurso(new Curso("Logistica","Noturno",3));
		
		
		assertEquals(escola_modelo.buscarCursoPorNome("Banco de Dados").size(),1);
		assertEquals(escola_modelo.buscarCursoPorNome("ADS").size(),1);
		assertEquals(escola_modelo.buscarCursoPorNome("Logistica").size(),1);
		//assertEquals(escola_modelo.buscarCursoPorNome("logistica").size(),1); //Nao encontra pq nao existe logistica com l minusculo cadastrado


		
		
		
		
		
		
		///////////////////////////////////////////////////////////////////
		//############PESQUISAS COM DADOS DIFERENTES#########
		//CURSO CADASTRADO COM DIFERENCA DE DIGITACAO###
		
		//NOME COM DIFERENCA DE DIGITACAO
		//assertEquals(escola_modelo.pesquisarCurso().get(0).getNome_curso(), "Banco De Dados");
		
		//PERIODO COM DIFERENCA DE DIGITACAO
		//assertEquals(escola_modelo.pesquisarCurso().get(0).getPeriodo(), "NOITE 1");
		
		//ID COM DIFERENCA DE DIGITACAO
		//assertEquals(escola_modelo.pesquisarCurso().get(0).getId(), "um");
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//############Materia############
		//############CADASTRO DE ALUNO NA CLASSE###############
		//CADASTRAR MATERIA
		escola_modelo.cadastrarMateria(new Materia(1,40,"Calculo","Conta"));
		
		
		//############CADASTRO COM DADOS INCOMPLETOS############
		//CADASTRO SEM ID
		//escola_modelo.cadastrarMateria(new Materia(401,"Calculo 1","Conta 1"));

		//CADASTRO SEM NOME DA MATERIA E DESCRICAO
		//escola_modelo.cadastrarMateria(new Materia(12,402));
		
		//CADASTRO SEM QUANTIDADE DE ALUNOS LIMITE
		//escola_modelo.cadastrarMateria(new Materia(13,"Calculo 3","Conta 3"));
		
		///////////////////////Materia///////////////////////////////////////
		
		escola_modelo.cadastrarMateria(new Materia(2,40,"Engenharia_Software","Java"));
		escola_modelo.cadastrarMateria(new Materia(3,40,"Linguagem_de_Programacao","C"));

		assertEquals(escola_modelo.buscarMateriaPorNome("Engenharia_Software").size(),1);
		assertEquals(escola_modelo.buscarMateriaPorNome("Linguagem_de_Programacao").size(),1);

		
		
		////////////////////////////////////////////////////////////////////
		//############PESQUISAS DE VARIAVEIS SEPARADAS##########
		//TESTAR MATERIA CADASTRADO
		//assertEquals(escola_modelo.pesquisarMateria().size(), 1);

		//PESQUISAR POR NUMERO DE VAGAS
		//assertEquals(escola_modelo.pesquisarMateria().size(), 1);

		//PESQUISAR POR NOME MATERIA
		//assertEquals(escola_modelo.pesquisarMateria().get(0).getNome_materia(), "Calculo");

		//PESQUISAR POR DESCRICAO
		//assertEquals(escola_modelo.pesquisarMateria().get(0).getDescricao_materia(), "Conta");
		
		//############PESQUISAS COM DADOS DIFERENTES############	
		//PESQUISA MATERIA COM DIFERNECA DE DIGITACAO
		//assertEquals(escola_modelo.pesquisarMateria().size(), "PRIMEIRO");
		
		//PESQUISAR VAGAS COM DIFERNECA DE DIGITACAO
		//assertEquals(escola_modelo.pesquisarMateria().size(), "dez");
		
		//PESQUISAR MATERIA COM DIFERNECA DE DIGITACAO
		//assertEquals(escola_modelo.pesquisarMateria().get(0).getNome_materia(), "CALCULO");
		
		//PESQUISAR A DESCRICAO COM DIFERNECA DE DIGITACAO
		//assertEquals(escola_modelo.pesquisarMateria().get(0).getDescricao_materia(), "CONTA");
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//fail("Not yet implemented");
	}

}
