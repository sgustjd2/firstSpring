package basic;

public class InsaImpl implements Insa {
	DAO dao;

	public InsaImpl() {
		System.out.println("InsaImpl 기본 생성자");
	}

	public InsaImpl(DAO dao) {
		super();
		System.out.println("InsaImpl DAO 생성자");
		this.dao = dao;
	}

	@Override
	public void addUser(MemberDTO user) {
		dao.add(user);
	}

	@Override
	public MemberDTO getUser(String id) {
		dao.getUser("id");
		return null;
	}

}
