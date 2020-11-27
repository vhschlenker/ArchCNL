/**
 * generated by Xtext 2.22.0
 */
package org.architecture.cnl.archcnl.impl;

import org.architecture.cnl.archcnl.ArchcnlPackage;
import org.architecture.cnl.archcnl.CardinalityRuleType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cardinality Rule Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.architecture.cnl.archcnl.impl.CardinalityRuleTypeImpl#getModifer <em>Modifer</em>}</li>
 *   <li>{@link org.architecture.cnl.archcnl.impl.CardinalityRuleTypeImpl#getObject <em>Object</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CardinalityRuleTypeImpl extends MinimalEObjectImpl.Container implements CardinalityRuleType
{
  /**
   * The default value of the '{@link #getModifer() <em>Modifer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifer()
   * @generated
   * @ordered
   */
  protected static final String MODIFER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getModifer() <em>Modifer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifer()
   * @generated
   * @ordered
   */
  protected String modifer = MODIFER_EDEFAULT;

  /**
   * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObject()
   * @generated
   * @ordered
   */
  protected org.architecture.cnl.archcnl.Object object;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CardinalityRuleTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArchcnlPackage.Literals.CARDINALITY_RULE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getModifer()
  {
    return modifer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setModifer(String newModifer)
  {
    String oldModifer = modifer;
    modifer = newModifer;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchcnlPackage.CARDINALITY_RULE_TYPE__MODIFER, oldModifer, modifer));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public org.architecture.cnl.archcnl.Object getObject()
  {
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObject(org.architecture.cnl.archcnl.Object newObject, NotificationChain msgs)
  {
    org.architecture.cnl.archcnl.Object oldObject = object;
    object = newObject;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArchcnlPackage.CARDINALITY_RULE_TYPE__OBJECT, oldObject, newObject);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setObject(org.architecture.cnl.archcnl.Object newObject)
  {
    if (newObject != object)
    {
      NotificationChain msgs = null;
      if (object != null)
        msgs = ((InternalEObject)object).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ArchcnlPackage.CARDINALITY_RULE_TYPE__OBJECT, null, msgs);
      if (newObject != null)
        msgs = ((InternalEObject)newObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ArchcnlPackage.CARDINALITY_RULE_TYPE__OBJECT, null, msgs);
      msgs = basicSetObject(newObject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ArchcnlPackage.CARDINALITY_RULE_TYPE__OBJECT, newObject, newObject));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ArchcnlPackage.CARDINALITY_RULE_TYPE__OBJECT:
        return basicSetObject(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ArchcnlPackage.CARDINALITY_RULE_TYPE__MODIFER:
        return getModifer();
      case ArchcnlPackage.CARDINALITY_RULE_TYPE__OBJECT:
        return getObject();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ArchcnlPackage.CARDINALITY_RULE_TYPE__MODIFER:
        setModifer((String)newValue);
        return;
      case ArchcnlPackage.CARDINALITY_RULE_TYPE__OBJECT:
        setObject((org.architecture.cnl.archcnl.Object)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ArchcnlPackage.CARDINALITY_RULE_TYPE__MODIFER:
        setModifer(MODIFER_EDEFAULT);
        return;
      case ArchcnlPackage.CARDINALITY_RULE_TYPE__OBJECT:
        setObject((org.architecture.cnl.archcnl.Object)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ArchcnlPackage.CARDINALITY_RULE_TYPE__MODIFER:
        return MODIFER_EDEFAULT == null ? modifer != null : !MODIFER_EDEFAULT.equals(modifer);
      case ArchcnlPackage.CARDINALITY_RULE_TYPE__OBJECT:
        return object != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (modifer: ");
    result.append(modifer);
    result.append(')');
    return result.toString();
  }

} //CardinalityRuleTypeImpl