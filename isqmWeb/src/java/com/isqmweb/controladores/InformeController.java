package com.isqmweb.controladores;

import com.isqmweb.entities.Informe;
import com.isqmweb.controladores.util.JsfUtil;
import com.isqmweb.controladores.util.PaginationHelper;
import com.isqmweb.factories.InformeFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("informeController")
@SessionScoped
public class InformeController implements Serializable {

    private Informe current;
    private DataModel items = null;
    @EJB
    private com.isqmweb.factories.InformeFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public InformeController() {
    }

    public Informe getSelected() {
        if (current == null) {
            current = new Informe();
            current.setInformePK(new com.isqmweb.entities.InformePK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private InformeFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Informe) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Informe();
        current.setInformePK(new com.isqmweb.entities.InformePK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getInformePK().setIdMonitoreos(current.getMonitoreo().getIdMonitoreos());
            current.getInformePK().setIdCapacitaciones(current.getCapacitacion().getIdCapacitaciones());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InformeCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Informe) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getInformePK().setIdMonitoreos(current.getMonitoreo().getIdMonitoreos());
            current.getInformePK().setIdCapacitaciones(current.getCapacitacion().getIdCapacitaciones());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InformeUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Informe) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("InformeDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Informe getInforme(com.isqmweb.entities.InformePK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Informe.class)
    public static class InformeControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InformeController controller = (InformeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "informeController");
            return controller.getInforme(getKey(value));
        }

        com.isqmweb.entities.InformePK getKey(String value) {
            com.isqmweb.entities.InformePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.isqmweb.entities.InformePK();
            key.setIdMonitoreos(Integer.parseInt(values[0]));
            key.setIdCapacitaciones(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.isqmweb.entities.InformePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdMonitoreos());
            sb.append(SEPARATOR);
            sb.append(value.getIdCapacitaciones());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Informe) {
                Informe o = (Informe) object;
                return getStringKey(o.getInformePK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Informe.class.getName());
            }
        }

    }

}
