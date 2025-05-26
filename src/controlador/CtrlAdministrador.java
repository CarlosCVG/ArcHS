//
//package controlador;
//
//import vista.ventanas.WinAdministrador;
//import vista.ventanas.WinRegistroEmp;
//import modelo.vo.Empleado;
//import modelo.logica.LogicEmpleado;
//import excepciones.ExBusiness;
//import java.time.LocalDate;
//import java.time.format.DateTimeParseException;
//import java.util.List;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//
//public class CtrlAdministrador {
//
//    private WinAdministrador vistaAdmin;
//    private WinRegistroEmp vistaRegistro;
//    private LogicEmpleado logica;
//    private Empleado empleadoSeleccionado;
//
//    public CtrlAdministrador(WinAdministrador vista) {
//        this.vistaAdmin = vista;
//        this.logica = new LogicEmpleado();
//        configurarListeners();
//        cargarTablaEmpleados();
//    }
//
//    public CtrlAdministrador(WinRegistroEmp vista) {
//        this.vistaRegistro = vista;
//        this.logica = new LogicEmpleado();
//        configurarListenersRegistro();
//    }
//
//    private void configurarListeners() {
//        // Configurar listeners para los botones en la ventana Admin
//        vistaAdmin.btnNewEmpleado.addActionListener(e -> abrirRegistroEmpleado());
//        vistaAdmin.btnEliminarEmp.addActionListener(e -> eliminarEmpleado());
//        vistaAdmin.btnModifOcupa.addActionListener(e -> modificarOcupacion());
//        vistaAdmin.btnModiEmplea.addActionListener(e -> modificarDatosEmpleado());
//        vistaAdmin.btnBuscar.addActionListener(e -> buscarEmpleadoPorId());
//    }
//
//    private void configurarListenersRegistro() {
//        // Configurar listener para el botón Agregar en RegistroEmp
//        vistaRegistro.btnAgregar.addActionListener(e -> agregarEmpleado());
//    }
//
//    // 1. Agregar un empleado
//    private void agregarEmpleado() {
//        try {
//            Empleado nuevo = construirEmpleadoDesdeVista(vistaRegistro);
//
//            // Validación de fecha de nacimiento (mayor de 18 años)
//            LocalDate fechaMinimaNacimiento = LocalDate.now().minusYears(18);
//            if (nuevo.getFecha_nac().isAfter(fechaMinimaNacimiento)) {
//                throw new ExBusiness("El empleado debe ser mayor de edad (18+ años)");
//            }
//
//            // Validación de fecha de contratación (no puede ser futura)
//            if (nuevo.getFecha_contrat().isAfter(LocalDate.now())) {
//                throw new ExBusiness("La fecha de contratación no puede ser futura");
//            }
//
//            // Validación que fecha contratación no sea anterior a fecha nacimiento
//            if (nuevo.getFecha_contrat().isBefore(nuevo.getFecha_nac())) {
//                throw new ExBusiness("La fecha de contratación no puede ser anterior a la fecha de nacimiento");
//            }
//
//            Empleado empleadoCreado = logica.agregarEmpleado(nuevo);
//            JOptionPane.showMessageDialog(vistaRegistro,
//                    "Empleado agregado con ID: " + empleadoCreado.getId_empleado(),
//                    "Éxito",
//                    JOptionPane.INFORMATION_MESSAGE);
//
//            volverAVentanaAdmin();
//        } catch (ExBusiness ex) {
//            JOptionPane.showMessageDialog(vistaRegistro, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(vistaRegistro,
//                    "Formato numérico incorrecto en algún campo",
//                    "Error",
//                    JOptionPane.ERROR_MESSAGE);
//        } catch (DateTimeParseException ex) {
//            JOptionPane.showMessageDialog(vistaRegistro,
//                    "Formato de fecha incorrecto. Use YYYY-MM-DD",
//                    "Error",
//                    JOptionPane.ERROR_MESSAGE);
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(vistaRegistro,
//                    "Error inesperado: " + ex.getMessage(),
//                    "Error",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//// Método para actualizar empleado
//    private void actualizarEmpleado() {
//        try {
//            if (empleadoSeleccionado == null) {
//                throw new ExBusiness("No se ha seleccionado ningún empleado para actualizar");
//            }
//
//            Empleado actualizado = construirEmpleadoDesdeVista(vistaRegistro, empleadoSeleccionado.getId_empleado());
//            actualizado.setUsuario(empleadoSeleccionado.getUsuario());
//            actualizado.setPass(empleadoSeleccionado.getPass());
//
//            logica.modificarEmpleado(actualizado);
//            JOptionPane.showMessageDialog(vistaRegistro, "Empleado actualizado correctamente");
//
//            // Regresar a la ventana principal
//            volverAVentanaAdmin();
//
//        } catch (ExBusiness ex) {
//            JOptionPane.showMessageDialog(vistaRegistro, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(vistaRegistro, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//// Método auxiliar para volver a Admin
//    private void volverAVentanaAdmin() {
//        WinAdministrador admin = new WinAdministrador();
//        admin.setVisible(true);
//        if (vistaRegistro != null) {
//            vistaRegistro.dispose();
//        }
//        if (vistaAdmin != null) {
//            vistaAdmin.dispose();
//        }
//    }
//
//    // parseFecha
//    private LocalDate parseFecha(String fechaStr, String campo) throws ExBusiness {
//        try {
//            return LocalDate.parse(fechaStr);
//        } catch (DateTimeParseException e) {
//            throw new ExBusiness("Formato de fecha incorrecto para " + campo + ". Use formato YYYY-MM-DD");
//        }
//    }
//
////    private Empleado construirEmpleadoDesdeVista(WinRegistroEmp vista, Integer idExistente) throws ExBusiness {
////        Empleado emp = new Empleado();
////        try {
////            
////            if (idExistente != null) {
////                emp.setId_empleado(idExistente);
////            }
////
////            emp.setId_admin(Integer.parseInt(vista.getTxtid_admin().getText()));
////            emp.setNss(Integer.parseInt(vista.getTxtNSS().getText()));
////            emp.setCurp(vista.getTxtCurp().getText());
////            emp.setTelefono(vista.getTxtTelefono().getText());
////            emp.setEmail(vista.getTxtEmail().getText());
////            emp.setRfc(vista.getTxtRFC().getText());
////            emp.setId_puesto(Integer.parseInt(vista.getTxtPuesto().getText()));
////            emp.setSueldo(vista.getTxtSueldo().getText());
////            emp.setFecha_nac(parseFecha(vista.getTxtFechaNac().getText(), "fecha de nacimiento"));
////            emp.setDireccion(vista.getTxtDireccion().getText());
////            emp.setFecha_contrat(parseFecha(vista.getTxtFechCon().getText(), "fecha de contratación"));
////            emp.setNombre(vista.getTxtNombre().getText());
////            emp.setAp1(vista.getTxtPrimerApe().getText());
////            emp.setAp2(vista.getTxtSegApe().getText());
////
////            return emp;
////        } catch (NumberFormatException e) {
////            throw new ExBusiness("Formato numérico inválido en algún campo");
////        }
////    }
//
//// Versión simplificada para cuando no necesitas el ID
//    private Empleado construirEmpleadoDesdeVista(WinRegistroEmp vista) throws ExBusiness {
//        return construirEmpleadoDesdeVista(vista, null);
//    }
//    // 2. Eliminar un empleado
//
//    private void eliminarEmpleado() {
//        if (empleadoSeleccionado == null) {
//            JOptionPane.showMessageDialog(vistaAdmin, "Seleccione un empleado primero", "Advertencia", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//        int confirmacion = JOptionPane.showConfirmDialog(
//                vistaAdmin,
//                "¿Está seguro de eliminar al empleado " + empleadoSeleccionado.getNombre() + "?",
//                "Confirmar eliminación",
//                JOptionPane.YES_NO_OPTION
//        );
//
//        if (confirmacion == JOptionPane.YES_OPTION) {
//            try {
//                boolean eliminado = logica.eliminarEmpleado(empleadoSeleccionado.getId_empleado());
//                if (eliminado) {
//                    JOptionPane.showMessageDialog(vistaAdmin, "Empleado eliminado correctamente");
//                    cargarTablaEmpleados();
//                    empleadoSeleccionado = null;
//                }
//            } catch (ExBusiness ex) {
//                JOptionPane.showMessageDialog(vistaAdmin, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//    // 3. Modificar ocupación del empleado
//    private void modificarOcupacion() {
//        try {
//            if (empleadoSeleccionado == null) {
//                JOptionPane.showMessageDialog(vistaAdmin,
//                        "Seleccione un empleado primero",
//                        "Advertencia",
//                        JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//
//            String nuevoPuestoStr = JOptionPane.showInputDialog(
//                    vistaAdmin,
//                    "Ingrese el nuevo ID de puesto para " + empleadoSeleccionado.getNombre() + ":",
//                    empleadoSeleccionado.getId_puesto()
//            );
//
//            if (nuevoPuestoStr != null && !nuevoPuestoStr.isEmpty()) {
//                int nuevoPuesto = Integer.parseInt(nuevoPuestoStr);
//
//                // Clonar el empleado existente y solo cambiar el puesto
//                Empleado empleadoActualizado = clonarEmpleado(empleadoSeleccionado);
//                empleadoActualizado.setId_puesto(nuevoPuesto);
//
//                // Llamar a un método especial que solo valide el puesto
//                logica.modificarSoloPuesto(empleadoActualizado);
//
//                JOptionPane.showMessageDialog(vistaAdmin,
//                        "Puesto actualizado correctamente",
//                        "Éxito",
//                        JOptionPane.INFORMATION_MESSAGE);
//
//                cargarTablaEmpleados();
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(vistaAdmin,
//                    "Ingrese un número válido para el puesto",
//                    "Error",
//                    JOptionPane.ERROR_MESSAGE);
//        } catch (ExBusiness e) {
//            JOptionPane.showMessageDialog(vistaAdmin,
//                    e.getMessage(),
//                    "Error",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private Empleado clonarEmpleado(Empleado original) {
//        Empleado clone = new Empleado();
//        // Copiar todos los campos del empleado original
//        clone.setId_empleado(original.getId_empleado());
//        clone.setUsuario(original.getUsuario());
//        clone.setPass(original.getPass());
//        clone.setId_admin(original.getId_admin());
//        clone.setNss(original.getNss());
//        clone.setCurp(original.getCurp());
//        clone.setTelefono(original.getTelefono());
//        clone.setEmail(original.getEmail());
//        clone.setRfc(original.getRfc());
//        clone.setId_puesto(original.getId_puesto());
//        clone.setSueldo(original.getSueldo());
//        clone.setFecha_nac(original.getFecha_nac());
//        clone.setDireccion(original.getDireccion());
//        clone.setFecha_contrat(original.getFecha_contrat());
//        clone.setNombre(original.getNombre());
//        clone.setAp1(original.getAp1());
//        clone.setAp2(original.getAp2());
//        return clone;
//    }
//
//    // 4. Modificar datos del empleado
//    private void modificarDatosEmpleado() {
//        if (empleadoSeleccionado == null) {
//            JOptionPane.showMessageDialog(vistaAdmin,
//                    "Seleccione un empleado primero",
//                    "Advertencia",
//                    JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//        WinRegistroEmp registro = new WinRegistroEmp();
//        registro.setVisible(true);
//        vistaAdmin.dispose();
//
//        // Llenar campos con datos actuales
//        llenarFormulario(registro, empleadoSeleccionado);
//
//        registro.btnAgregar.setText("Actualizar");
//
//        registro.btnAgregar.addActionListener(e -> {
//            try {
//                Empleado cambios = construirEmpleadoDesdeVista(registro);
//
//                // Verificar si hay cambios reales
//                if (!hayCambiosSignificativos(empleadoSeleccionado, cambios)) {
//                    throw new ExBusiness("No se detectaron cambios para guardar");
//                }
//
//                // Aplicar cambios al empleado existente
//                aplicarCambios(empleadoSeleccionado, cambios);
//
//                // Intentar guardar
//                Empleado actualizado = logica.modificarEmpleado(empleadoSeleccionado);
//
//                // Mostrar confirmación
//                mostrarConfirmacionActualizacion(actualizado);
//                volverAVentanaAdmin();
//
//            } catch (ExBusiness ex) {
//                mostrarErrorActualizacion(ex);
//            }
//        });
//    }
//
//// Métodos auxiliares
//    private void llenarFormulario(WinRegistroEmp vista, Empleado empleado) {
//        vista.getTxtid_admin().setText(String.valueOf(empleado.getId_admin()));
//        vista.getTxtNSS().setText(String.valueOf(empleado.getNss()));
//        vista.getTxtCurp().setText(empleado.getCurp());
//        vista.getTxtTelefono().setText(empleado.getTelefono());
//        vista.getTxtEmail().setText(empleado.getEmail());
//        vista.getTxtRFC().setText(empleado.getRfc());
//        vista.getTxtPuesto().setText(String.valueOf(empleado.getId_puesto()));
//        vista.getTxtSueldo().setText(empleado.getSueldo());
//        vista.getTxtFechaNac().setText(empleado.getFecha_nac().toString());
//        vista.getTxtDireccion().setText(empleado.getDireccion());
//        vista.getTxtFechCon().setText(empleado.getFecha_contrat().toString());
//        vista.getTxtNombre().setText(empleado.getNombre());
//        vista.getTxtPrimerApe().setText(empleado.getAp1());
//        vista.getTxtSegApe().setText(empleado.getAp2());
//    }
//
//    private boolean hayCambiosSignificativos(Empleado original, Empleado cambios) {
//        return original.getId_admin() != cambios.getId_admin()
//                || original.getNss() != cambios.getNss()
//                || !original.getCurp().equals(cambios.getCurp())
//                || !original.getTelefono().equals(cambios.getTelefono())
//                || !original.getEmail().equals(cambios.getEmail())
//                || !original.getRfc().equals(cambios.getRfc())
//                || original.getId_puesto() != cambios.getId_puesto()
//                || !original.getSueldo().equals(cambios.getSueldo())
//                || !original.getFecha_nac().equals(cambios.getFecha_nac())
//                || !original.getDireccion().equals(cambios.getDireccion())
//                || !original.getFecha_contrat().equals(cambios.getFecha_contrat())
//                || !original.getNombre().equals(cambios.getNombre())
//                || !original.getAp1().equals(cambios.getAp1())
//                || !original.getAp2().equals(cambios.getAp2());
//    }
//
//    private void aplicarCambios(Empleado destino, Empleado fuente) {
//        destino.setId_admin(fuente.getId_admin());
//        destino.setNss(fuente.getNss());
//        destino.setCurp(fuente.getCurp());
//        destino.setTelefono(fuente.getTelefono());
//        destino.setEmail(fuente.getEmail());
//        destino.setRfc(fuente.getRfc());
//        destino.setId_puesto(fuente.getId_puesto());
//        destino.setSueldo(fuente.getSueldo());
//        destino.setFecha_nac(fuente.getFecha_nac());
//        destino.setDireccion(fuente.getDireccion());
//        destino.setFecha_contrat(fuente.getFecha_contrat());
//        destino.setNombre(fuente.getNombre());
//        destino.setAp1(fuente.getAp1());
//        destino.setAp2(fuente.getAp2());
//        destino.setId_puesto(fuente.getId_puesto());
//    }
//
//    private void mostrarConfirmacionActualizacion(Empleado empleado) {
//        JOptionPane.showMessageDialog(null,
//                "Empleado actualizado exitosamente:\n"
//                + "ID: " + empleado.getId_empleado() + "\n"
//                + "Nombre: " + empleado.getNombre() + " " + empleado.getAp1() + "\n"
//                + "NSS: " + empleado.getNss() + "\n"
//                + "Puesto: " + empleado.getId_puesto(),
//                "Actualización Exitosa",
//                JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    private void mostrarErrorActualizacion(ExBusiness ex) {
//        JOptionPane.showMessageDialog(null,
//                "Error al actualizar empleado:\n" + ex.getMessage(),
//                "Error en Actualización",
//                JOptionPane.ERROR_MESSAGE);
//    }
//
//    private boolean empleadoIgual(Empleado original, Empleado actualizado) {
//        return original.getNss() == actualizado.getNss()
//                && original.getCurp().equals(actualizado.getCurp())
//                && original.getRfc().equals(actualizado.getRfc())
//                && original.getTelefono().equals(actualizado.getTelefono())
//                && original.getEmail().equals(actualizado.getEmail())
//                && original.getId_puesto() == actualizado.getId_puesto()
//                && original.getSueldo().equals(actualizado.getSueldo())
//                && original.getFecha_nac().equals(actualizado.getFecha_nac())
//                && original.getDireccion().equals(actualizado.getDireccion())
//                && original.getFecha_contrat().equals(actualizado.getFecha_contrat())
//                && original.getNombre().equals(actualizado.getNombre())
//                && original.getAp1().equals(actualizado.getAp1())
//                && original.getAp2().equals(actualizado.getAp2());
//    }
//
//    // 5. Búsqueda del empleado por ID
//    private void buscarEmpleadoPorId() {
//        String idStr = vistaAdmin.txtBuscaEmple.getText();
//        if (idStr == null || idStr.trim().isEmpty()) {
//            JOptionPane.showMessageDialog(vistaAdmin, "Ingrese un ID para buscar", "Advertencia", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//
//        try {
//            int id = Integer.parseInt(idStr);
//            Empleado empleado = logica.consultarEmpleado(id);
//
//            if (empleado != null) {
//                empleadoSeleccionado = empleado;
//
//                // Resaltar en la tabla (si está implementada)
//                resaltarEmpleadoEnTabla(id);
//
//                JOptionPane.showMessageDialog(vistaAdmin,
//                        "Empleado encontrado:\n"
//                        + "Nombre: " + empleado.getNombre() + " " + empleado.getAp1() + "\n"
//                        + "Puesto: " + empleado.getId_puesto() + "\n"
//                        + "NSS: " + empleado.getNss(),
//                        "Resultado de búsqueda",
//                        JOptionPane.INFORMATION_MESSAGE
//                );
//            } else {
//                JOptionPane.showMessageDialog(vistaAdmin, "No se encontró un empleado con ID: " + id, "Resultado", JOptionPane.INFORMATION_MESSAGE);
//            }
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(vistaAdmin, "Ingrese un ID numérico válido", "Error", JOptionPane.ERROR_MESSAGE);
//        } catch (ExBusiness ex) {
//            JOptionPane.showMessageDialog(vistaAdmin, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void resaltarEmpleadoEnTabla(int id) {
//        DefaultTableModel model = (DefaultTableModel) vistaAdmin.tabDatosEmp.getModel();
//        for (int i = 0; i < model.getRowCount(); i++) {
//            if (Integer.parseInt(model.getValueAt(i, 0).toString()) == id) {
//                vistaAdmin.tabDatosEmp.setRowSelectionInterval(i, i);
//                vistaAdmin.tabDatosEmp.scrollRectToVisible(vistaAdmin.tabDatosEmp.getCellRect(i, 0, true));
//                break;
//            }
//        }
//    }
//
//    private void abrirRegistroEmpleado() {
//        WinRegistroEmp registro = new WinRegistroEmp();
//        registro.setVisible(true);
//        vistaAdmin.dispose();
//        new CtrlAdministrador(registro);
//    }
//
//    private void cargarTablaEmpleados() {
//        List<Empleado> empleados = logica.consultarEmpleados();
//        DefaultTableModel model = new DefaultTableModel();
//
//        // Configurar columnas
//        model.addColumn("ID Empleado");
//        model.addColumn("CURP");
//        model.addColumn("Teléfono");
//        model.addColumn("Email");
//        model.addColumn("ID Puesto");
//        model.addColumn("Nombre");
//        model.addColumn("Primer Apellido");
//
//        // Llenar datos con solo la información requerida
//        for (Empleado emp : empleados) {
//            model.addRow(new Object[]{
//                emp.getId_empleado(),
//                emp.getCurp(),
//                emp.getTelefono(),
//                emp.getEmail(),
//                emp.getId_puesto(),
//                emp.getNombre(),
//                emp.getAp1()
//            });
//        }
//
//        vistaAdmin.tabDatosEmp.setModel(model);
//
//        // Configurar listener para selección de empleado
//        vistaAdmin.tabDatosEmp.getSelectionModel().addListSelectionListener(e -> {
//            if (!e.getValueIsAdjusting()) {
//                int selectedRow = vistaAdmin.tabDatosEmp.getSelectedRow();
//                if (selectedRow >= 0) {
//                    int id = (int) vistaAdmin.tabDatosEmp.getValueAt(selectedRow, 0);
//                    try {
//                        empleadoSeleccionado = logica.consultarEmpleado(id);
//                    } catch (ExBusiness ex) {
//                        JOptionPane.showMessageDialog(vistaAdmin, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//                }
//            }
//        });
//    }
//}
