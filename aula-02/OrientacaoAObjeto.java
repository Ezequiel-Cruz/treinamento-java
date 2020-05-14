import java.util.ArrayList; //interface
import java.util.List; // Implementação da Interface

class Ponto {
    protected int posicaoX;
    protected int posicaoY;
    protected int posicaoZ;

    Ponto(int posicaoX,  int posicaoY, int posicaoZ) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        this.posicaoZ = posicaoZ;
    }
}

abstract class FormaGeometrica {
    protected Ponto pontoCentral;

    FormaGeometrica(int posicaoX,  int posicaoY, int posicaoZ) {
        this.pontoCentral = new Ponto( posicaoX, posicaoY, posicaoZ);
    }

     public String toString() {
        return " ponto central: (" + this.pontoCentral.posicaoX + "," + this.pontoCentral.posicaoY + "," + this.pontoCentral.posicaoZ + ")";
    }
}

interface Forma2D {
    FormaGeometrica extrusaoLinear(int altura);
}

interface Forma3D {
    FormaGeometrica extrusaoLinear(int largura, int comprimento);
}


class Quadrado extends FormaGeometrica implements Forma2D {
    protected int largura;
    protected int comprimento;


    Quadrado(int largura, int comprimento, int posicaoX,  int posicaoY, int posicaoZ) {
        super(posicaoX, posicaoY, posicaoZ);
        this.largura = largura;
        this.comprimento = comprimento;
    }

    @Override
     public String toString() {
        return "largura: " + this.largura + " comprimento: " + this.comprimento + super.toString();
    }

    public Cubo extrusaoLinear(int altura) {
        return new Cubo(this.largura, this.comprimento, altura, this.pontoCentral.posicaoX, this.pontoCentral.posicaoY, this.pontoCentral.posicaoZ);
    }
}

class Circulo extends FormaGeometrica {
    protected int raio;

    Circulo(int raio, int posicaoX,  int posicaoY, int posicaoZ) {
        super(posicaoX, posicaoY, posicaoZ);
        this.raio = raio;
        
    }

    @Override
    public String toString() {
        return "raio: " + this.raio + super.toString();
    }
}

class Cubo extends FormaGeometrica {
    protected int largura;
    protected int comprimento;
    protected int altura;


    Cubo(int largura, int comprimento, int altura, int posicaoX,  int posicaoY, int posicaoZ) {
        super(posicaoX, posicaoY, posicaoZ);
        this.largura = largura;
        this.comprimento = comprimento;
        this.altura = altura;
    }

    @Override
     public String toString() {
        return "largura: " + this.largura + " comprimento: " + this.comprimento + " altura: " + this.altura + super.toString();
    }

     public Quadrado extrusaoLinear(int largura, int comprimento) {
        return new Quadrado(this.largura, this.comprimento, this.pontoCentral.posicaoX, this.pontoCentral.posicaoY, this.pontoCentral.posicaoZ);
    }
}

class Cilindro extends FormaGeometrica {
    protected int raio;
    protected int altura;

    Cilindro(int raio, int altura, int posicaoX,  int posicaoY, int posicaoZ) {
        super(posicaoX, posicaoY, posicaoZ);
        this.raio = raio;
        this.altura = altura;
        
    }

    @Override
    public String toString() {
        return "raio: " + this.raio + "altura: " + this.altura + super.toString();
    }
}

public class OrientacaoAObjeto {

    public static void main(String[] args) {

        Circulo c1 = new Circulo(10, 0, 0, 0);
        Quadrado q1 = new Quadrado(10, 10, 15, 15, 15);

        Cubo cb1 = q1.extrusaoLinear(7);

        Quadrado q2 = cb1.extrusaoLinear(10,10);

        List<FormaGeometrica> formas = new ArrayList();
        formas.add(q1);
        formas.add(c1);
        formas.add(cb1);
        formas.add(q2);

        for(FormaGeometrica q: formas) {
            System.out.println(q);
        }

    }
}
