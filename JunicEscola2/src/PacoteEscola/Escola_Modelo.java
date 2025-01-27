package PacoteEscola;
import java.util.LinkedList;
import java.util.List;

//import APPBank.Usuario;


public class Escola_Modelo {

	String nome;
	int CEP;
	//int Cpf;
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	private List<Aluno> alunos = new LinkedList<Aluno>();
	private List<Curso> cursos = new LinkedList<Curso>();
	private List<Funcionario> funcionarios = new LinkedList<Funcionario>();
	private List<Materia> materias = new LinkedList<Materia>();
	
	
////////////////////////////////////////////////////////////////////////////////
// METODOS da classe ALUNO
	public void cadastrarAluno(Aluno aluno){
		if(alunoRepetido(aluno.getEmail(), aluno.getcpf(), aluno.getra())){
			alunos.add(aluno);
		}
		else {
			System.out.println("Aluno ja cadastrado");
		}
	}
	
	public boolean alunoRepetido(String email, int cpf, int ra){
		for(Aluno aluno:alunos){
			if(aluno.getEmail().equals(email) || aluno.getcpf()==(cpf) || aluno.getra()==(ra)) return false;
		}
		return true;
	}
	
	public List<Aluno> pesquisarAluno(){
		
		return this.alunos;
	}
	
	public List<Aluno> getAlunos(){
		return this.alunos;
		}
////////////////////////////////////////////////////////////////////////////////
	//METODOS CLASSE CURSO
	
	public void cadastrarCurso(Curso curso){
		if (cursoRepetido(curso.getId(), curso.getNome_curso())) {
		cursos.add(curso);
		}else {
			System.out.println("Curso ja cadastrado");
		}
	}
	
	public boolean cursoRepetido (int id, String nome_curso) {
		for (Curso curso: cursos) {
			if(curso.getId()==id|| curso.getNome_curso().equals(nome_curso)) return false;
		} 
			return true;
		
			
	}
	

		public List<Curso> pesquisarCurso(){
			
			return this.cursos;
		}
////////////////////////////////////////////////////////////////////////////////
	//METODOS CLASSE MATERIA
		
		public void cadastrarMateria(Materia materia){
			if (materiaRepetida(materia.getNome_materia(), materia.getId())) {
			materias.add(materia);
			}else {
				System.out.println("Materia ja cadastrado");
			}
}

		public boolean materiaRepetida (String nome_materia, int id) {
			for (Materia materia:materias) {
				if (materia.getId()==id|| materia.getNome_materia().equals(nome_materia)) return false;
			}return true;
		}


		
			public List<Materia> pesquisarMateria(){
				return this.materias;
			}
			
////////////////////////////////////////////////////////////////////////////////
	//METODOS CLASSE FUNCIONARIO
		
		public void cadastrarFuncionario(Funcionario funcionario){
			if (funcionarioRepetido(funcionario.getCpf(), funcionario.getNome_completo())) {
				funcionarios.add(funcionario);
			}else {
				System.out.println("Funcionario ja cadastrado");
			}
			
			}
		
		public boolean funcionarioRepetido (int cpf, String nome) {
			for (Funcionario funcionario:funcionarios) {
				if (funcionario.getCpf()==cpf||funcionario.getNome_completo().equals(nome)) return false;
			}return true;
			
		}
		

		
		public List<Funcionario> pesquisarFuncionario(){
				
			return this.funcionarios;
			}
}
