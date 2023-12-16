package AdministradorTienda;

public class Venta {
	
	private int numeroVenta = 0;

	private Producto producto;
	
	private int cantidadCajas = 0;
	private double porcentajeDescuento = 0;

	private double importeCompra = 0, importeDescuento = 0, importePagar = 0;
	
	private String tipoObsequio = "";
	private int cantidadObsequios = 0;
	
	
	public Venta(Producto producto, int cantidadCajas) {
		//this.numeroVenta = MainApp.calcularCantidadVentasTotales();
		this.numeroVenta = MainApp.getGestorProductos().calcularCantidadVentasTotales();
		
		this.producto = producto;
		
		this.cantidadCajas = cantidadCajas;
		this.porcentajeDescuento = Utilidades.calcularPorcentajeDescuento(this.cantidadCajas);
		
		this.importeCompra = this.cantidadCajas * this.producto.getPrecio();
		this.importeDescuento = this.importeCompra * (this.porcentajeDescuento / 100);
		this.importePagar = this.importeCompra - this.importeDescuento;
		
		this.tipoObsequio = MainApp.getTipoObsequio();
		this.cantidadObsequios = Utilidades.calcularCantidadObsequios(this.cantidadCajas * this.producto.getContenido());
	}

	// GETTERS Y SETTERS
	
	public int getNumeroVenta() {
		return numeroVenta;
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
		
		boleta += "Modelo\t\t: " + this.producto.getModelo() + " \n";
		boleta += "Precio\t\t: S/. " + this.producto.getPrecio() + " \n";
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
