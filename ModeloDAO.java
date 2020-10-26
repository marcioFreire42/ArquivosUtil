public class ModeloDAO {
    // Modelo de DAO sem salvamento na mémoria do dispositivo. 
        
        private final static List<Empresa> empresas = new ArrayList<>();
        private static int geraId = 1; // Gerador estático de Ids
    
        public void salvaEmpresa(Empresa emp){
                // Recebe um objeto e salva ele no Dao atribuindo um Id
            emp.setId(geraId);
            empresas.add(emp);
            geraId++;
        }
    
        public void editaEmpresa(Empresa empresa){
            Empresa empresaEncontrada = retornaEmpresaPeloId(empresa);
    
            if (empresaEncontrada != null){
                int posicaoEmpresaEncontrada = empresas.indexOf(empresaEncontrada);
                // Encontra no Arraylist a posição em que a empresa foi encontrada;
    
                empresas.set(posicaoEmpresaEncontrada, empresa);
                // Substitui o elemento da posição pelo novo objeto que foi recebido;
            }
            // A lógica desse método consiste em passar por todo o objeto recebido pelo Arraylist;
            // Comparando os Ids, afim de saber se aquele objeto já está na lista;
            // Se ele for encontrado em seguida pegamos sua posição e substituimos os objetos.
        }
    
        public List<Empresa> retorna(){
            return new ArrayList<>(empresas);
                // Retorna todos os objetos do Dao;
        }
    
        public void remove(Empresa empresaEscolhida) {
            Empresa empresaDevolvida = retornaEmpresaPeloId(empresaEscolhida);
    
            if (empresaDevolvida != null){
                empresas.remove(empresaDevolvida);
            }
        }
    
        public Empresa retornaEmpresaPeloId(Empresa empresa){
            Empresa empresaEncontrada = null;
            for (Empresa e: empresas) {
                if(e.getId() == empresa.getId()){
                    empresaEncontrada = e;
                    //Compara o ID do objeto recebido com o ID de todos os objetos da lista, 
                    // Se o id é encontrado o objeto é repassado;
                }
            }
            return empresaEncontrada;
        }
    }