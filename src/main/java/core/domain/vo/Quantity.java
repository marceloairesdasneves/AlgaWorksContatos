package core.domain.vo;

// @author Marcelo Neves

public record Quantity (int ativos){

    public Quantity{
        if(ativos <= 0){
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }

    }

}
