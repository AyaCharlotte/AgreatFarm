package kro.kr.agreatfarm.vo;

public class MemberVO 
{
	private int 	m_num;
	private boolean	m_farmer;
	private String	m_email, m_password, m_nickname;
	
	public int		getM_num()							{ return m_num;					}
	public void		setM_num(int m_num)					{ this.m_num = m_num;			}
	
	public boolean	isM_farmer()						{ return m_farmer;				}
	public void		setM_farmer(boolean m_farmer)		{ this.m_farmer = m_farmer;		}
	
	public String	getM_email()						{ return m_email;				}
	public void		setM_email(String m_email)			{ this.m_email = m_email;		}
	
	public String	getM_password()						{ return m_password;			}
	public void		setM_password(String m_password)	{ this.m_password = m_password;	}
	
	public String	getM_nickname() 					{ return m_nickname;			}
	public void		setM_nickname(String m_nickname)	{ this.m_nickname = m_nickname;	}
}
