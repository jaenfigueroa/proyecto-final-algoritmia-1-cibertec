package AdministradorTienda;

class Producto {
	public String modelo;
	public double precio;
	public double ancho;
	public double largo;
	public double espesor;
	public int contenido;
	public String imagen;

	// contadores y acumuladores
	public int cantidadVentas = 0;
	public int cantidadCajasVendidas = 0;
	public double importeTotalVendido = 0;

	public Producto(String modelo, double precio, double ancho, double largo, double espesor, int contenido, String imagen) {
		this.modelo = modelo;
		this.precio = precio;
		this.ancho = ancho;
		this.largo = largo;
		this.espesor = espesor;
		this.contenido = contenido;
		this.imagen = imagen;
	}

	void actualizarProducto(double nuevoPrecio, double nuevoAncho, double nuevoLargo, double nuevoEspesor, int nuevoContenido) {
		this.precio = nuevoPrecio;
		this.ancho = nuevoAncho;
		this.largo = nuevoLargo;
		this.espesor = nuevoEspesor;
		this.contenido = nuevoContenido;
	}

	void venderProducto(int cajasVendidas, double importePagar) {
		this.cantidadVentas++;
		this.cantidadCajasVendidas += cajasVendidas;
		this.importeTotalVendido += importePagar;
	}
}