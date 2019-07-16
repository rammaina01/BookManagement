package com.hon.lib.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "User")
public class User
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer userId;
  @NotNull
  private String firstName;
  @NotNull
  private String lastName;
  @NotNull
  @Column(unique = true, length = 32)
  private String mobileNumber;
  private String address;

  public User()
  {
  }

  public User(Integer userId, String firstName, String lastName, String mobileNumber, String address)
  {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.mobileNumber = mobileNumber;
    this.address = address;
  }

  public Integer getUserId()
  {
    return userId;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getMobileNumber()
  {
    return mobileNumber;
  }

  public String getAddress()
  {
    return address;
  }

  public void setUserId(Integer userId)
  {
    this.userId = userId;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public void setMobileNumber(String mobileNumber)
  {
    this.mobileNumber = mobileNumber;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }
}
