package org.shiftone.jrat.provider.tree.ui.hierarchy;

import org.jdesktop.swingx.treetable.AbstractTreeTableModel;
import org.shiftone.jrat.desktop.util.tables.AbstractTable;
import org.shiftone.jrat.desktop.util.tables.Column;
import org.shiftone.jrat.desktop.util.tables.HierarchyTable;
import org.shiftone.jrat.provider.tree.ui.hierarchy.nodes.HierarchyNode;
import org.shiftone.jrat.provider.tree.ui.hierarchy.nodes.MethodHierarchyNode;
import org.shiftone.jrat.provider.tree.ui.hierarchy.nodes.PackageHierarchyNode;

import java.util.List;

/**
 * @author jeff@shiftone.org (Jeff Drost)
 */
public class HierarchyTreeTableModel extends AbstractTreeTableModel {

    public static final AbstractTable TABLE = new HierarchyTable();

    private final PackageHierarchyNode root;

    public HierarchyTreeTableModel(PackageHierarchyNode root) {
        this.root = root;
    }

    public static List<Column> getColumns() {
        return TABLE.getColumns();
    }

    public Class getColumnClass(int i) {
        return TABLE.getColumn(i).getType();
    }

    public int getColumnCount() {
        return TABLE.getColumnCount();
    }

    public String getColumnName(int i) {
        return TABLE.getColumn(i).getName();
    }

    public Object getValueAt(Object o, int i) {

        HierarchyNode node = (HierarchyNode) o;

        if (TABLE.getIndexForName(HierarchyTable.CLASS) == i) {
            return o.toString();
        }
        if (TABLE.getIndexForName(HierarchyTable.METHODS) == i) {
            return getTotalMethods(node);
        }
        if (TABLE.getIndexForName(HierarchyTable.UNCALLED) == i) {
            return getUncalledMethods(node);
        }
        if (TABLE.getIndexForName(HierarchyTable.COVERAGE) == i) {
            return node.getCoverage();
        }
        if (TABLE.getIndexForName(HierarchyTable.TOTAL) == i) {
            return new Long(node.getTotalDuration());
        }
        if (TABLE.getIndexForName(HierarchyTable.TOTAL_METHOD) == i) {
            return node.getTotalMethodDuration();
        }
        if (TABLE.getIndexForName(HierarchyTable.PERCENT_METHOD) == i) {
            return node.getTotalMethodPercent();
        }
        if (TABLE.getIndexForName(HierarchyTable.TOTAL_EXITS) == i) {
            return new Long(node.getTotalExits());
        }
        if (TABLE.getIndexForName(HierarchyTable.EXCEPTIONS) == i) {
            return new Long(node.getTotalErrors());
        }
        if (TABLE.getIndexForName(HierarchyTable.ERROR_RATE) == i) {
            return node.getErrorRate();
        }
        return null;
    }

    private static Integer getTotalMethods(HierarchyNode node) {
        return (node instanceof MethodHierarchyNode) ? null : new Integer(node.getTotalMethods());
    }

    private static Integer getUncalledMethods(HierarchyNode node) {
        return (node instanceof MethodHierarchyNode) ? null : new Integer(node.getUncalledMethods());
    }

    public boolean isCellEditable(Object o, int i) {
        return false;
    }

    public void setValueAt(Object o, Object o1, int i) {
        throw new UnsupportedOperationException();
    }

    public Object getRoot() {
        return root;
    }

    public Object getChild(Object parent, int index) {
        return node(parent).getChild(index);
    }

    public int getChildCount(Object parent) {
        return node(parent).getChildCount();
    }

    public int getIndexOfChild(Object parent, Object child) {
        return node(parent).getIndexOfChild((HierarchyNode) child);
    }

    public boolean isLeaf(Object o) {
        return node(o).isLeaf();
    }

    private HierarchyNode node(Object o) {
        return (HierarchyNode) o;
    }
}
