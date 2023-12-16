package AdministradorTienda;

public class Venta {
	
	private int numeroVenta = 0;

	private String nombre = "";
	private double precio = 0;
	private int cantidadUnidades = 0;
	
	private int cantidadCajas = 0;
	private double porcentajeDescuento = 0;

	private double importeCompra = 0, importeDescuento = 0, importePagar = 0;
	
	private String tipoObsequio = "";
	private int cantidadObsequios = 0;
	
	
	public Venta(Producto producto, int cantidadCajas) {
		this.numeroVenta = MainApp.calcularCantidadVentasTotales();
		
		this.nombre = producto.getModelo();
		this.precio = producto.getPrecio();
		this.cantidadUnidades = producto.getContenido();
		
		this.cantidadCajas = cantidadCajas;
		this.porcentajeDescuento = MainApp.calcularPorcentajeDescuento(this.cantidadCajas * this.cantidadUnidades);
		
		this.importeCompra = this.cantidadCajas * this.precio;
		this.importeDescuento = this.importeCompra * (this.porcentajeDescuento / 100);
		this.importePagar = this.importeCompra - this.importeDescuento;
		
		this.tipoObsequio = MainApp.getTipoObsequio();
		this.cantidadObsequios = MainApp.calcularCantidadObsequios(this.cantidadCajas);
	}

	// GETTERS Y SETTERS
	
	public int getNumeroVenta() {
		return numeroVenta;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCantidadUnidades() {
		return cantidadUnidades;
	}

	public int getCantidadCajas() {
		return cantidadCajas;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	
	public double getImporteCompra() {
		return importeCompra;
	}

	public double getImporteDescuento() {
		return importeDescuento;
	}

	public double getImportePagar() {
		return importePagar;
	}

	
	public int getCantidadObsequios() {
		return cantidadObsequios;
	}
	
	public String getTipoObsequio() {
		return tipoObsequio;
	}
	
	
	// OTROS METODOS

	String generarBoleta(){
		String boleta = "BOLETA DE VENTA\n\n";
		
		boleta += "Modelo\t\t: " + this.nombre + " \n";
		boleta += "Precio\t\t: S/. " + this.precio + " \n";
		boleta += "Cantidad cajas adquiridas\t: " + this.cantidadCajas + " \n\n";
		boleta += "Importe de compra\t: S/. " + this.importeCompra + " \n";
		boleta += "Importe de descuento\t: S/. " + this.importeDescuento + " \n";
		boleta += "Importe de pagar\t: S/. " + this.importePagar + "\n\n";
		boleta += "Tipo de obsequio\t: " + this.tipoObsequio + "\n";
		boleta += "Unidades obsequiadas\t: " + this.cantidadObsequios;
		
		return boleta;
	}
	
	boolean verificarVentaMultiplo5() {
		return this.numeroVenta % 5 == 0;
	}
}
