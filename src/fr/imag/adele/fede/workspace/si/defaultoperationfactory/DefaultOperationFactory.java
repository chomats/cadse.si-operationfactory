/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package fr.imag.adele.fede.workspace.si.defaultoperationfactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fede.workspace.tool.loadmodel.model.jaxb.CLinkDescription;
import fede.workspace.tool.loadmodel.model.jaxb.COperation;
import fede.workspace.tool.loadmodel.model.jaxb.COperationEx;
import fede.workspace.tool.loadmodel.model.jaxb.COperationParam;
import fede.workspace.tool.loadmodel.model.jaxb.COperationParamBoolean;
import fede.workspace.tool.loadmodel.model.jaxb.COperationParamItemDescription;
import fede.workspace.tool.loadmodel.model.jaxb.COperationParamItemRef;
import fede.workspace.tool.loadmodel.model.jaxb.COperationParamItemtypeRef;
import fede.workspace.tool.loadmodel.model.jaxb.COperationParamLinkRef;
import fede.workspace.tool.loadmodel.model.jaxb.COperationParamLinktypeRef;
import fede.workspace.tool.loadmodel.model.jaxb.COperationParamOther;
import fede.workspace.tool.loadmodel.model.jaxb.COperationParamString;
import fede.workspace.tool.loadmodel.model.jaxb.CValuesType;
import fede.workspace.tool.loadmodel.model.jaxb.ObjectFactory;
import fede.workspace.tool.loadmodel.model.jaxb.ValueTypeType;
import fede.workspace.tool.view.oper.WSCheckItemInViewer;
import fede.workspace.tool.view.oper.WSODeleteItemAndContent;
import fr.imag.adele.cadse.core.CadseDomain;
import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.CadseGCST;
import fr.imag.adele.cadse.core.CompactUUID;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemDescription;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkDescription;
import fr.imag.adele.cadse.core.LinkType;
import fr.imag.adele.cadse.core.LogicalWorkspace;
import fr.imag.adele.cadse.core.impl.CadseCore;
import fr.imag.adele.cadse.core.oper.WSCheckAttribute;
import fr.imag.adele.cadse.core.oper.WSCheckContent;
import fr.imag.adele.cadse.core.oper.WSCheckItem;
import fr.imag.adele.cadse.core.oper.WSCheckMapping;
import fr.imag.adele.cadse.core.oper.WSOCommitItem;
import fr.imag.adele.cadse.core.oper.WSOCreateLink;
import fr.imag.adele.cadse.core.oper.WSODeleteLink;
import fr.imag.adele.cadse.core.oper.WSOGenerateContent;
import fr.imag.adele.cadse.core.oper.WSOSetAttribute;
import fr.imag.adele.cadse.core.oper.WSOperation;
import fr.imag.adele.cadse.core.oper.annotation.OperParameter;
import fr.imag.adele.cadse.core.oper.annotation.OperTest;
import fr.imag.adele.cadse.core.oper.annotation.ParameterKind;
import fr.imag.adele.cadse.core.transaction.LogicalWorkspaceTransaction;
import fr.imag.adele.fede.workspace.as.operationfactory.IOperationFactory;
import fr.imag.adele.fede.workspace.as.test.TestException;

/**
 * @generated
 */
public class DefaultOperationFactory implements IOperationFactory {

	/**
	 * @generated
	 */
	CadseDomain	workspaceCU;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imag.adele.fede.workspace.as.operationfactory.IOperationFactory#equals(fede.workspace.tool.loadmodel.model.jaxb.COperationEx,
	 *      java.lang.Throwable)
	 */
	public boolean equals(COperationEx coper, Throwable ex) {
		return coper.getMsg().equals(ex.getMessage());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imag.adele.fede.workspace.as.operationfactory.IOperationFactory#getName()
	 */
	public String getName() {
		return "DefaultOperationFactory";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imag.adele.fede.workspace.as.operationfactory.IOperationFactory#manage(fr.imag.adele.cadse.core.oper.WSOperation)
	 */
	public boolean manage(WSOperation oper) {
		Class<?> type = oper.getClass();
		OperTest annotationTest = type.getAnnotation(OperTest.class);
		if (annotationTest != null) {
			return true;
		}

		if (oper instanceof WSOCreateLink) {
			return true;
		}
		if (oper instanceof WSODeleteLink) {
			return true;
		}
		if (oper instanceof WSOCommitItem) {
			return true;
		}
		if (oper instanceof WSODeleteItemAndContent) {
			return true;
		}
		if (oper instanceof WSCheckItemInViewer) {
			return true;
		}
		if (oper instanceof WSCheckItem) {
			return true;
		}
		if (oper instanceof WSCheckAttribute) {
			return true;
		}
		if (oper instanceof WSCheckContent) {
			return true;
		}
		if (oper instanceof WSCheckMapping) {
			return true;
		}
		if (oper instanceof WSOGenerateContent) {
			return true;
		}
		if (oper instanceof WSOSetAttribute) {
			return true;
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imag.adele.fede.workspace.as.operationfactory.IOperationFactory#manage(java.lang.Throwable)
	 */
	public boolean manage(Throwable e) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imag.adele.fede.workspace.as.operationfactory.IOperationFactory#read(fede.workspace.tool.loadmodel.model.jaxb.COperation)
	 */
	public WSOperation read(COperation coper) throws Throwable {
		String type = coper.getType();
		int index = type.indexOf(":");
		String subType = type.substring(index + 1);
		try {
			Class<?> beantype = this.getClass().getClassLoader().loadClass(subType);
			OperTest annotationTest = beantype.getAnnotation(OperTest.class);
			if (annotationTest != null) {
				LogicalWorkspaceTransaction copy = workspaceCU.getLogicalWorkspace().createTransaction();
				Field[] fields = beantype.getDeclaredFields();
				Map<Integer, Object> values = new HashMap<Integer, Object>();
				Map<Integer, Class> classes = new HashMap<Integer, Class>();
				for (Field f : fields) {
					OperParameter paramInfo = f.getAnnotation(OperParameter.class);
					if (paramInfo == null) {
						continue;
					}
					ParameterKind paramType = paramInfo.type();
					String name = BeanCore.getPropertyName(f, paramInfo.name());
					Object value = null;
					Class clazz = null;
					switch (paramType) {
						case wl:
							value = workspaceCU.getLogicalWorkspace();
							clazz = LogicalWorkspace.class;
							break;
						case object_value:
							CValuesType ctvalue = getAttributeValue(name, coper);
							value = createValue(ctvalue);
							clazz = Object.class;
							break;
						case string_value:
							value = getStringParam(name, coper);
							clazz = String.class;
							break;
						case boolean_value:
							value = getBooleanParam(name, coper);
							clazz = Boolean.class;
							break;
						case item_desc:
							value = getItemDescParam(copy, name, coper);
							clazz = Item.class;
							break;
						case item_ref:
							value = getItemRefFromParam(name, coper);
							clazz = Item.class;
							break;
						case item_type_ref:
							value = getItemTypeRefFromParam(name, coper);
							clazz = ItemType.class;
							break;
						case link_type_ref:
							value = getLinkTypeRef(name, coper);
							clazz = LinkType.class;
							break;
						case link_ref:
							value = getLinkRefParam(coper, name);
							clazz = Link.class;
							break;
						default:
							continue;
					}
					values.put(paramInfo.constructorPosition(), value);
					classes.put(paramInfo.constructorPosition(), clazz);
				}
				Class<?>[] classparam = new Class<?>[values.size()];
				Object[] objparam = new Object[values.size()];
				for (int i = 0; i < objparam.length; i++) {
					objparam[i] = values.get(i);
					;
					classparam[i] = classes.get(i);
				}
				Constructor<?> c = beantype.getConstructor(classparam);
				return (WSOperation) c.newInstance(objparam);
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (subType.equals("WSOCreateLink")) {
			WSOCreateLink oper;
			LinkType linktype = getLinkTypeRef("lt", coper);
			Item source = getItemRefFromParam("source", coper);
			Item dest = getItemRefFromParam("dest", coper);
			;
			oper = new WSOCreateLink(source, linktype, dest);
			return oper;
		}
		if (subType.equals("WSOCommitItem")) {
			LogicalWorkspaceTransaction copy = workspaceCU.getLogicalWorkspace().createTransaction();
			Item returnItem = getItemDescParam(copy, "item", coper);

			return new WSOCommitItem(copy);
		}
		if (subType.equals("WSODeleteLink")) {
			Link l = getLinkRefParam(coper, "l");
			return new WSODeleteLink(l);
		}

		if (subType.equals("WSODeleteItemAndContent")) {
			return new WSODeleteItemAndContent(getItemRefFromParam("item", coper), getBooleanParam("delete-content",
					coper), getStringParam("error-msg", coper), getBooleanParam("delete-eclipse-resource", coper));
		}
		if (subType.equals("WSCheckItemInViewer")) {
			return new WSCheckItemInViewer(getStringParam("view-id", coper), getStringParam("view-second-id", coper),
					getStringParam("node-id", coper));
		}

		if (subType.equals("WSCheckItem")) {
			return new WSCheckItem(workspaceCU.getLogicalWorkspace(), getStringParam("item-id", coper));
		}
		if (subType.equals("WSCheckAttribute")) {
			CValuesType value = getAttributeValue("value", coper);
			return new WSCheckAttribute(getItemRefFromParam("item", coper), value.getKey(), createValue(value));
		}
		if (subType.equals("WSCheckContent")) {
			return new WSCheckContent(getItemRefFromParam("item", coper), getStringParam("qualified-class-name", coper));
		}
		if (subType.equals("WSCheckMapping")) {
			return new WSCheckMapping(getItemRefFromParam("item", coper), getStringParam("qualified-class-name", coper));
		}

		return null;
	}

	private LinkType getLinkTypeRef(String name, COperation coper) throws TestException {
		COperationParamLinktypeRef param = getParam(coper, name, COperationParamLinktypeRef.class);
		return getLinkTypeRef(param);
	}

	private LinkType getLinkTypeRef(COperationParamLinktypeRef param) throws TestException {
		if (param == null) {
			return null;// TODO Auto-generated method stub
		}
		ItemType it = workspaceCU.getLogicalWorkspace().getItemType(new CompactUUID(param.getTypeRef()));
		if (it == null) {
			throw new TestException("cannot_found_item_type_from_parameter_in_operation",
					Messages.cannot_found_item_type_from_parameter_in_operation, null, param.getTypeRef());
		}
		LinkType lt = it.getOutgoingLinkType(param.getLinkTypeName());
		if (it == null) {
			throw new TestException("cannot_found_item_type_from_parameter_in_operation",
					Messages.cannot_found_item_type_from_parameter_in_operation, null, param.getLinkTypeName(), it
							.getType().getName());
		}
		return lt;
	}

	private Item getItemRefFromParam(String name, COperation coper) {
		COperationParamItemRef param = getParam(coper, name, COperationParamItemRef.class);
		return getItemRef(param);
	}

	private Item getItemRef(COperationParamItemRef param) {
		if (param == null) {
			return null;
		}
		return null;
	}

	private String getStringParam(String name, COperation coper) {
		COperationParamString param = getParam(coper, name, COperationParamString.class);
		if (param == null) {
			return null;
		}
		return param.getValue();
	}

	private boolean getBooleanParam(String name, COperation coper) {
		COperationParamBoolean param = getParam(coper, name, COperationParamBoolean.class);
		if (param == null) {
			return false;
		}
		return param.isValue();
	}

	private ItemType getItemTypeRefFromParam(String name, COperation coper) throws TestException {
		COperationParamItemtypeRef param = getParam(coper, name, COperationParamItemtypeRef.class);
		ItemType it = getItemTypeRef(param);

		return it;
	}

	private ItemType getItemTypeRef(COperationParamItemtypeRef param) throws TestException {
		if (param == null) {
			return null;// TODO Auto-generated method stub
		}
		ItemType it = workspaceCU.getLogicalWorkspace().getItemType(new CompactUUID(param.getTypeRef()));
		if (it == null) {
			throw new TestException("cannot_found_item_type_from_parameter_in_operation",
					Messages.cannot_found_item_type_from_parameter_in_operation, null, param.getTypeRef());
		}
		return it;
	}

	private Item getItemDescParam(LogicalWorkspaceTransaction copy, String name, COperation coper)
			throws TestException, CadseException {
		COperationParamItemDescription param = getParam(coper, name, COperationParamItemDescription.class);
		if (param == null) {
			return null;
		}
		ItemType it = getItemTypeRef(param);
		Item parent = getItemRef(param.getParent());
		LinkType lt = getLinkTypeRef(param.getParentLinkType());
		Item returnItem = copy.createItem(it, parent, lt);

		loadItemParam(param, coper, returnItem, it, parent, lt);
		return returnItem;
	}

	private <T extends COperationParam> T getParam(COperation coper, String name, Class<T> clazz) {
		for (COperationParam p : coper.getParam()) {
			if (name.equals(p.getName()) && clazz.isInstance(p)) {
				return (T) p;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imag.adele.fede.workspace.as.operationfactory.IOperationFactory#write(fr.imag.adele.cadse.core.oper.WSOperation,
	 *      fede.workspace.tool.loadmodel.model.jaxb.ObjectFactory)
	 */
	public COperation write(WSOperation oper, ObjectFactory factory) throws CadseException {
		Class<?> type = oper.getClass();
		OperTest annotationTest = type.getAnnotation(OperTest.class);
		if (annotationTest != null) {
			COperation ret = factory.createCOperation();
			ret.setType(getName() + ":" + type.getCanonicalName());
			ret.setComment(oper.getDiplayComment());
			Field[] fields = type.getDeclaredFields();
			for (Field f : fields) {
				OperParameter paramInfo = f.getAnnotation(OperParameter.class);
				if (paramInfo == null) {
					continue;
				}
				ParameterKind paramType = paramInfo.type();
				String name = BeanCore.getPropertyName(f, paramInfo.name());
				Object value = BeanCore.getValue(type, oper, name, f, null);
				if (value == null) {
					continue;
				}

				switch (paramType) {
					case wl:
						continue;
					case object_value:
						createAttributeValue(factory, ret, name, name, value);
						break;
					case string_value:
						createStringParam(factory, ret, name, (String) value);
						break;
					case boolean_value:
						createBooleanParam(factory, ret, name, (Boolean) value);
						break;
					case item_desc:
						createItemParam(factory, ret, name, (ItemDescription) value);
						break;
					case item_ref:
						createItemRefParam(factory, ret, name, (Item) value);
						break;
					case item_type_ref:
						createItemTypeRefParam(factory, ret, name, (ItemType) value);
						break;
					case link_type_ref:
						createLinkTypeRefParam(factory, ret, null, (LinkType) value);
						break;
					case link_ref:
						createLinkRefParam(factory, ret, name, (Link) value);
						break;
					default:
						break;
				}
			}
			ret.setShoulBeStopIfError(annotationTest.testMustBeStopped());
			return ret;
		}
		if (oper instanceof WSOCreateLink) {
			COperation ret = factory.createCOperation();
			ret.setType(getName() + ":WSOCreateLink");
			createItemRefParam(factory, ret, "source", ((WSOCreateLink) oper).getSource());
			createItemRefParam(factory, ret, "dest", ((WSOCreateLink) oper).getDest());
			createLinkTypeRefParam(factory, ret, "lt", ((WSOCreateLink) oper).getLinktype());
			ret.setComment(oper.getDiplayComment());
			ret.setShoulBeStopIfError(true);
			return ret;
		}
		if (oper instanceof WSODeleteLink) {
			COperation ret = factory.createCOperation();
			ret.setType(getName() + ":WSODeleteLink");
			createLinkRefParam(factory, ret, "l", ((WSODeleteLink) oper).getLink());
			ret.setComment(oper.getDiplayComment());
			ret.setShoulBeStopIfError(true);
			return ret;
		}
		if (oper instanceof WSOCommitItem) {
			COperation ret = factory.createCOperation();
			ret.setType(getName() + ":WSOCommitItem");
			ItemDescription itemDesc = ((WSOCommitItem) oper).getItem();
			Item item = workspaceCU.getLogicalWorkspace().getItem(itemDesc.getId());

			createItemParam(factory, ret, "item", itemDesc);

			ret.setComment(oper.getDiplayComment());
			ret.setShoulBeStopIfError(true);
			return ret;
		}
		if (oper instanceof WSODeleteItemAndContent) {
			COperation ret = factory.createCOperation();
			ret.setType(getName() + ":WSODeleteItemAndContent");
			WSODeleteItemAndContent goodoper = ((WSODeleteItemAndContent) oper);
			createItemRefParam(factory, ret, "item", goodoper.getItem());
			createStringParam(factory, ret, "error-msg", goodoper.getErrorMsg());
			createBooleanParam(factory, ret, "delete-content", goodoper.isDeleteContent());
			createBooleanParam(factory, ret, "delete-eclipse-resource", goodoper.isDeleteEclipseResource());
			ret.setComment(oper.getDiplayComment());
			ret.setShoulBeStopIfError(true);
			return ret;
		}
		if (oper instanceof WSCheckItemInViewer) {
			COperation ret = factory.createCOperation();
			ret.setType(getName() + ":WSCheckItemInViewer");
			WSCheckItemInViewer goodoper = ((WSCheckItemInViewer) oper);
			createStringParam(factory, ret, "view-id", goodoper.getViewId());
			createStringParam(factory, ret, "view-second-id", goodoper.getViewSecondId());
			createStringParam(factory, ret, "node-id", goodoper.getNodeIdentifier());
			ret.setComment(oper.getDiplayComment());
			ret.setShoulBeStopIfError(false);
			return ret;
		}
		if (oper instanceof WSCheckItem) {
			COperation ret = factory.createCOperation();
			ret.setType(getName() + ":WSCheckItem");
			WSCheckItem goodoper = ((WSCheckItem) oper);
			createStringParam(factory, ret, "item-id", goodoper.getHandleIdentifier());
			ret.setComment(oper.getDiplayComment());
			ret.setShoulBeStopIfError(false);
			return ret;
		}
		if (oper instanceof WSCheckAttribute) {
			COperation ret = factory.createCOperation();
			ret.setType(getName() + ":WSCheckAttribute");
			WSCheckAttribute goodoper = ((WSCheckAttribute) oper);
			createItemRefParam(factory, ret, "item", goodoper.getItem());
			createAttributeValue(factory, ret, "value", goodoper.getKey(), goodoper.getValue());
			ret.setComment(oper.getDiplayComment());
			ret.setShoulBeStopIfError(false);
			return ret;
		}
		if (oper instanceof WSCheckContent) {
			COperation ret = factory.createCOperation();
			ret.setType(getName() + ":WSCheckContent");
			WSCheckContent goodoper = ((WSCheckContent) oper);
			createItemRefParam(factory, ret, "item", goodoper.getItem());
			createStringParam(factory, ret, "qualified-class-name", goodoper.getQualifiedClassName());
			ret.setComment(oper.getDiplayComment());
			ret.setShoulBeStopIfError(false);
			return ret;
		}
		if (oper instanceof WSCheckMapping) {
			COperation ret = factory.createCOperation();
			ret.setType(getName() + ":WSCheckMapping");
			WSCheckMapping goodoper = ((WSCheckMapping) oper);
			createItemRefParam(factory, ret, "item", goodoper.getItem());
			createStringParam(factory, ret, "qualified-class-name", goodoper.getQualifiedClassName());
			ret.setComment(oper.getDiplayComment());
			ret.setShoulBeStopIfError(false);
			return ret;
		}

		if (oper instanceof WSOGenerateContent) {
			COperation ret = factory.createCOperation();
			WSOGenerateContent goodoper = ((WSOGenerateContent) oper);
			ret.setType(getName() + ":WSOGenerateContent");
			createItemRefParam(factory, ret, "item", goodoper.getItem());
			ret.setComment(oper.getDiplayComment());
			ret.setShoulBeStopIfError(true);
			return ret;
		}
		if (oper instanceof WSOSetAttribute) {
			COperation ret = factory.createCOperation();
			WSOSetAttribute goodoper = ((WSOSetAttribute) oper);
			ret.setType(getName() + ":WSOSetAttribute");
			createItemRefParam(factory, ret, "item", goodoper.getItem());
			createStringParam(factory, ret, "key", goodoper.getKey());
			createAttributeValue(factory, ret, "value", goodoper.getKey(), goodoper.getValue());
			ret.setComment(oper.getDiplayComment());
			ret.setShoulBeStopIfError(true);
			return ret;
		}
		return null;
	}

	private void createItemParam(ObjectFactory factory, COperation ret, String name, ItemDescription item)
			throws CadseException {
		COperationParamItemDescription param = factory.createCOperationParamItemDescription();

		param.setName(name);
		param.setShortName(item.getName());
		param.setTypeRef(item.getType().toString());

		Item itemInWl = this.workspaceCU.getLogicalWorkspace().getItem(item.getId());
		if (itemInWl.getPartParent() != null) {
			param.setParent(createItemRef(factory, "parent", itemInWl.getPartParent()));
			param.setParentLinkType(createLinkTypeRef(factory, name, itemInWl.getPartParentLinkType()));
		}

		Map<String, Object> attributes = item.getAttributes();
		if (attributes != null) {
			for (String k : attributes.keySet()) {
				Object v = attributes.get(k);
				if (v == null) {
					continue;
				}
				addAttribute(factory, param, k, v);
			}
		}
		addAttribute(factory, param, CadseGCST.ITEM_at_QUALIFIED_NAME, item.getQualifiedName());
		if (item.getLinks() != null) {
			for (LinkDescription l : item.getLinks()) {
				addLink(factory, param, l);
			}
		}
		ret.getParam().add(param);
	}

	private boolean loadItemParam(COperationParamItemDescription param, COperation coper, Item item, ItemType it,
			Item parent, LinkType parent_lt) throws CadseException {
		item.setName(param.getShortName());

		String uniqueName = null;
		if (!it.hasUniqueNameAttribute()) {
			uniqueName = Item.NO_VALUE_STRING;
		} else {
			uniqueName = CadseCore.getName(item, param.getShortName(), parent, parent_lt);
		}
		item.setQualifiedName(uniqueName);

		List<CValuesType> attributes = param.getAttributesValue();
		for (CValuesType vt : attributes) {
			String k = vt.getKey();
			if (k.equals(CadseGCST.ITEM_at_QUALIFIED_NAME)) {
				continue;
			}

			Object value = createValue(vt);

			if (value == null) {
				continue;
			}

			item.setAttribute(k, value);
		}
		List<CLinkDescription> links = param.getOutgoingLink();
		for (CLinkDescription ld : links) {
			Item dest = null;
			if (dest == null) {
				throw new TestException("cannot_found_link_destination", "Cannot found Item from identifier {0} ",
						null, ld.getKey());
			}
			LinkType link_lt = item.getType().getOutgoingLinkType(ld.getType());
			if (link_lt == null) {
				throw new TestException("cannot_found_link_type", "Cannot found link type {0} from {1} ", null, ld
						.getKey(), item.getType().getName());
			}
			item.createLink(link_lt, dest);
		}
		return true;
	}

	private void addLink(ObjectFactory factory, COperationParamItemDescription param, LinkDescription l)
			throws CadseException {
		CompactUUID destId = l.getDestination().getId();
		Item dest = workspaceCU.getLogicalWorkspace().getItem(destId);
		CLinkDescription ld = factory.createCLinkDescription();
		// ld.setKey(dest.getHandleIdentifier());
		ld.setType(l.getType());
		param.getOutgoingLink().add(ld);

	}

	private void createAttributeValue(ObjectFactory factory, COperation ret, String name, String k, Object v)
			throws CadseException {
		COperationParamOther param = factory.createCOperationParamOther();
		param.setName(name);
		CValuesType cvt = factory.createCValuesType();
		cvt.setKey(k);
		if (setAttributValue(factory, v, cvt)) {
			param.setValue(cvt);
			ret.getParam().add(param);
		}

	}

	CValuesType getAttributeValue(String name, COperation coper) {
		COperationParamOther param = getParam(coper, name, COperationParamOther.class);
		if (param == null) {
			return null;
		}
		return param.getValue();
	}

	private void addAttribute(ObjectFactory factory, COperationParamItemDescription param, String k, Object v)
			throws CadseException {
		CValuesType cvt = factory.createCValuesType();
		cvt.setKey(k);
		if (setAttributValue(factory, v, cvt)) {
			param.getAttributesValue().add(cvt);
		}
	}

	private static boolean setAttributValue(ObjectFactory factory, Object v, CValuesType cvt) throws CadseException {
		if (v == null) {
			cvt.setType(ValueTypeType.NULL_VALUE);
			return true;
		}
		if (v instanceof List) {
			cvt.setType(ValueTypeType.LIST);
			for (Object o : (List) v) {
				CValuesType ncvt = factory.createCValuesType();
				cvt.getElement().add(ncvt);
				setAttributValue(factory, o, ncvt);
			}
			return true;
		}
		if (v instanceof Map) {
			cvt.setType(ValueTypeType.MAP);
			for (String k : ((Map<String, Object>) v).keySet()) {
				Object o = ((Map<String, Object>) v).get(k);
				CValuesType ncvt = factory.createCValuesType();
				cvt.getElement().add(ncvt);
				ncvt.setKey(k);
				setAttributValue(factory, o, ncvt);
			}
			return true;
		} else if (v instanceof Boolean) {
			cvt.setType(ValueTypeType.BOOLEAN);
			cvt.setValue(v.toString());
			return true;
		} else if (v instanceof Integer) {
			cvt.setType(ValueTypeType.INTEGER);
			cvt.setValue(v.toString());
			return true;
		} else if (v instanceof String) {
			cvt.setType(ValueTypeType.STRING);
			cvt.setValue(v.toString());
			return true;
		} else if (v instanceof Double) {
			cvt.setType(ValueTypeType.DOUBLE);
			cvt.setValue(v.toString());
			return true;
		} else if (v instanceof Link) {
			cvt.setType(ValueTypeType.LINK);
			cvt.setValue("");
			return true;
		} else if (v instanceof Enum) {
			cvt.setType(ValueTypeType.ENUMERATION);
			Class enumQualifiedClass = v.getClass();
			// BundleClassLoader classLoader =
			// enumQualifiedClass.getClassLoader();
			// classLoader.getDelegate().
			if (enumQualifiedClass != null) {
				cvt.setTypeName(enumQualifiedClass.getName());
			}
			cvt.setValue(((Enum) v).name());
			return true;
		}
		return false;
	}

	private void createLinkRefParam(ObjectFactory factory, COperation ret, String name, Link link)
			throws CadseException {
		COperationParamLinkRef param = factory.createCOperationParamLinkRef();
		param.setName(name);
		param.setLinkTypeName(link.getLinkType().getName());
		param.setTypeRef(link.getSource().getType().getId().toString());
		param.setDestination(createItemRef(factory, "dest", link.getDestination()));
		param.setSource(createItemRef(factory, "src", link.getSource()));
		ret.getParam().add(param);
	}

	private Link getLinkRefParam(COperation ret, String name) throws TestException {
		COperationParamLinkRef param = getParam(ret, name, COperationParamLinkRef.class);

		ItemType it = workspaceCU.getLogicalWorkspace().getItemType(new CompactUUID(param.getTypeRef()));
		if (it == null) {
			throw new TestException("Cannot found type " + param.getTypeRef());
		}
		LinkType lt = it.getOutgoingLinkType(param.getLinkTypeName());
		if (lt == null) {
			throw new TestException("Cannot found link type " + param.getTypeRef() + ":" + param.getLinkTypeName());
		}
		throw new TestException("Cannot found item source " + param.getSource().getItemId());

	}

	private void createItemTypeRefParam(ObjectFactory factory, COperation ret, String name, ItemType it) {
		COperationParamItemtypeRef param = factory.createCOperationParamItemtypeRef();
		param.setName(name);
		param.setTypeRef(it.getId().toString());
		ret.getParam().add(param);
	}

	private void createLinkTypeRefParam(ObjectFactory factory, COperation ret, String name, LinkType linktype) {
		COperationParamLinktypeRef param = createLinkTypeRef(factory, name, linktype);
		ret.getParam().add(param);
	}

	private COperationParamLinktypeRef createLinkTypeRef(ObjectFactory factory, String name, LinkType linktype) {
		COperationParamLinktypeRef param = factory.createCOperationParamLinktypeRef();
		param.setName(name);
		param.setTypeRef(linktype.getSource().getId().toString());
		param.setLinkTypeName(linktype.getName());
		return param;
	}

	private COperationParamItemRef createItemRef(ObjectFactory factory, String name, Item item) throws CadseException {
		COperationParamItemRef param = factory.createCOperationParamItemRef();
		param.setName(name);
		param.setTypeRef(item.getType().getId().toString());
		// param.setItemId(item.getHandleIdentifier());
		return param;
	}

	private void createItemRefParam(ObjectFactory factory, COperation ret, String name, Item item)
			throws CadseException {
		COperationParamItemRef param = createItemRef(factory, name, item);
		ret.getParam().add(param);
	}

	private void createStringParam(ObjectFactory factory, COperation ret, String name, String value) {
		if (value == null) {
			return;
		}
		COperationParamString param = factory.createCOperationParamString();
		param.setName(name);
		param.setValue(value);
		ret.getParam().add(param);
	}

	private void createBooleanParam(ObjectFactory factory, COperation ret, String name, boolean value) {
		COperationParamBoolean param = factory.createCOperationParamBoolean();
		param.setName(name);
		param.setValue(value);
		ret.getParam().add(param);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.imag.adele.fede.workspace.as.operationfactory.IOperationFactory#write(java.lang.Throwable,
	 *      fede.workspace.tool.loadmodel.model.jaxb.ObjectFactory)
	 */
	public COperationEx write(Throwable ex, ObjectFactory factory) {
		COperationEx cex = factory.createCOperationEx();
		cex.setMsg(ex.getMessage());
		cex.setType(ex.getClass().getName());
		return cex;
	}

	/**
	 * Creates the attritute type.
	 * 
	 * @param type
	 *            the type
	 * @param cadseName
	 *            the cadse name
	 * 
	 * @return the i attribute type<? extends object>
	 * @throws CadseException
	 */
	private Object createValue(CValuesType type) throws CadseException {
		ValueTypeType kind = type.getType();
		switch (kind) {
			case NULL_VALUE:
				return null;

			case LIST: {
				List<CValuesType> elements = type.getElement();
				ArrayList<Object> container = new ArrayList<Object>();
				for (CValuesType cvt_element : elements) {
					container.add(createValue(cvt_element));
				}
				return container;
			}
			case MAP: {
				List<CValuesType> elements = type.getElement();
				Map<String, Object> container = new HashMap<String, Object>();
				for (CValuesType cvt_element : elements) {
					Object v = createValue(cvt_element);
					if (v == null) {
						continue;
					}
					container.put(cvt_element.getKey(), v);
				}

				return container;
			}
			case BOOLEAN: {
				return Boolean.valueOf(type.getValue());
			}
			case STRING: {
				return type.getValue();
			}
			case INTEGER: {
				return Integer.valueOf(type.getValue());
			}
			case DOUBLE: {
				return Double.valueOf(type.getValue());
			}

				// case ENUMERATION: {
				// Class<? extends Enum> clazz = loadClass(cadseName,
				// type.getTypeName());
				// if (clazz == null)
				// throw new MelusineError("cannot create type from
				// {0}",type.getKey());
				// return new EnumAttributeType(
				// type.getKey(),
				// clazz ,
				// type.getMin(),
				// type.getValue());
				// }
		}
		throw new TestException("cannot_create_value", "cannot create value from {0}", null, type.getKey());

	}

}
