package emlakcepte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakcepte.client.Banner;
import emlakcepte.client.BannerServiceClient;
import emlakcepte.model.Realty;
import emlakcepte.model.User;
import emlakcepte.model.enums.PropertyType;
import emlakcepte.model.enums.RealtyType;
import emlakcepte.model.enums.UserType;
import emlakcepte.repository.RealtyRepository;

@Service
public class RealtyService {

	@Autowired
	private RealtyRepository realtyDao;

	//@Autowired // injection
	//private UserService userService;

	@Autowired
	private BannerServiceClient bannerServiceClient;


	public void createRealty(Realty realty) {

		
		if (PropertyType.HOUSING.equals(realty.getPropertyTpe())) {
			 if (realty.getUser().getRealtyList().size()<3){
				 System.out.println("yayınlandı"+ realty.getTitle());
			 }
			 else {
					System.out.println("Bireysel Kullanıcılar 3 ilan verebilir"+ realty);
				}
			 
		} else {
			realtyDao.saveRealty(realty);
			 System.out.println("yayınlandı"+ realty.getTitle());
		}
	}

		
		// TODO :: banner-service çağır ve banner siparişi ver

		//Banner bannerRequest = new Banner(String.valueOf(realty.getNo()), 1, "123123", "");
		
		//Banner bannerResponse = bannerServiceClient.create(bannerRequest);

		

	public List<Realty> getAll() {
		return realtyDao.findAll();
	}

	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}

	public void getAllByProvince(String province) {

		getAll().stream().filter(realty -> realty.getProvince().equals(province))
				// .count();
				.forEach(realty -> System.out.println(realty));

	}

	public void getAllByProvince2(String province, String town) {

		getAll().stream().filter(realty -> realty.getProvince().equals(province))
				.filter(realty -> realty.getProvince().equals(town))
				.forEach(realty -> System.out.println(realty));
	}
	public List<Realty> getAllByUserName(User user) {
		return getAll().stream().filter(realty -> realty.getUser().getMail().equals(user.getMail())).toList();
	}

	public List<Realty> getActiveRealtyByUserName(User user) {

		return getAll().stream().filter(realty -> realty.getUser().getName().equals(user.getName()))
				.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus())).toList();

	}
	public long getRealtyInProvince(String province){

        return getAll().stream()
                .filter(realty -> realty.getProvince().equals(province))
                .count();
    }
  public long getRealtiesInProvince(List<String> provinces){
        return getAll().stream()
                .filter(realty -> provinces.contains(realty.getProvince()))
                .count();
    }



}
