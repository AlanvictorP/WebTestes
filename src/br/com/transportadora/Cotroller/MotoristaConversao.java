package br.com.transportadora.Cotroller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.transportadora.DAO.MotoristaDAO;
import br.com.transportadora.Model.Motorista;


@FacesConverter("motoristaConversao")
public class MotoristaConversao implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		try{
			Long codigo = Long.parseLong(arg2);
			MotoristaDAO daoPessoa = new MotoristaDAO();
			Motorista pessoa = daoPessoa.buscaPorCodigo(codigo);
			return pessoa;
		}catch(RuntimeException ex){
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		try{
			Motorista pessoa = (Motorista) arg2;
			Long codigo = pessoa.getCodigo();
			
			return codigo.toString();
		}catch(RuntimeException ex){
			return null;
		}
	}

}
