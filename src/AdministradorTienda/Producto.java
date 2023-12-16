package AdministradorTienda;

class Producto {
	private String modelo;
	private double precio;
	private double ancho;
	private double largo;
	private double espesor;
	private int contenido;
	private String imagen;

	private int cantidadVentas = 0;
	private int cantidadCajasVendidas = 0;
	private double importeTotalVendido = 0;
	

	public Producto(String modelo, double precio, double ancho, double largo, double espesor, int contenido, String imagen) {
		this.modelo = modelo;
		this.precio = precio;
		this.ancho = ancho;
		this.largo = largo;
		this.espesor = espesor;
		this.contenido = contenido;
		this.imagen = imagen;
	}
	
	// GETTERS Y SETTERS

	public String getModelo() {
		return modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getEspesor() {
		return espesor;
	}

	public void setEspesor(double espesor) {
		this.espesor = espesor;
	}

	public int getContenido() {
		return contenido;
	}

	public void setContenido(int contenido) {
		this.contenido = contenido;
	}

	public String getImagen() {
		return imagen;
	}

	
	
	public int getCantidadVentas() {
		return cantidadVentas;
	}

	public void setCantidadVentas(int cantidadVentas) {
		this.cantidadVentas = cantidadVentas;
	}

	public int getCantidadCajasVendidas() {
		return cantidadCajasVendidas;
	}

	public void setCantidadCajasVendidas(int cantidadCajasVendidas) {
		this.cantidadCajasVendidas = cantidadCajasVendidas;
	}

	public double getImporteTotalVendido() {
		return importeTotalVendido;
	}

	public void setImporteTotalVendido(double importeTotalVendido) {
		this.importeTotalVendido = importeTotalVendido;
	}

	// OTROS METODOS

	void actulizarContadoresDespuesVenta(int cajasVendidas, double importePagar) {
		this.cantidadVentas++;
		this.cantidadCajasVendidas += cajasVendidas;
		this.importeTotalVendido += importePagar;
	}
	
}