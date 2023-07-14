![enoca](https://github.com/caferbayram/employee-management/assets/119615702/884253a8-4e92-4a0e-a0fb-34eeebb86ac7)

Company-Employee Management Program

Company
Bu tablo kullanıcının şirket ekleyebilmesi, görüntüleyebilmesi, güncellemesi, çıkarabilmesi için bulunuyor.
Şirketin adı, telefon numarası, adresi, bölgesi ve ID'sini tutmakta.
Employee ile One To Many ilişki içerisindedir.

Employee
Bu tablo şirketin elemanlarını ekleyebilmesi, görüntüleyebilmesi, güncellemesi ve çıkarabilmesi için bulunuyor.
Çalışanın adı, telefon numarası, adresi, departmanı ve bulunduğu şirketin ID'sini tutmaktadır.
Company ile Many To One ilişki içerisindedir.

İki path'te de GET, POST, PUT, DELETE HTTP Metodları bulunmaktadır.

Company eklemek için requestimiz :
{
    "name": "ENOCA",
    "address": "Flora Residans Vedat Günyol Caddesi Defne Sokak No:1 Kat:25 Ofis:2501,2502",
    "region": "Ataşehir/İstanbul",
    "phoneNumber": "0216 266 24 05"
}
Response :
{
    "id": 1,
    "name": "ENOCA",
    "address": "Flora Residans Vedat Günyol Caddesi Defne Sokak No:1 Kat:25 Ofis:2501,2502",
    "region": "Ataşehir/İstanbul",
    "phoneNumber": "0216 266 24 05",
    "employeeList": []
}

Employee eklemek için requestimiz :
{
    "name":"Cafer Malik BAYRAM",
    "phoneNumber":"0507 895 1991",
    "address":"Kavakpınar Mah., Yaylak Sokak., No: 8/4",
    "department":"Back-End Developer",
    "companyId":1
}
Response : 
{
    "id": 2,
    "name": "Cafer Malik BAYRAM",
    "phoneNumber": "0507 895 1991",
    "address": "Kavakpınar Mah., Yaylak Sokak., No: 8/4",
    "department": "Back-End Developer",
    "company": {
        "id": 1,
        "name": "ENOCA",
        "address": "Flora Residans Vedat Günyol Caddesi Defne Sokak No:1 Kat:25 Ofis:2501,2502",
        "region": "Ataşehir/İstanbul",
        "phoneNumber": "0216 266 24 05",
        "employeeList": []
    }
}
