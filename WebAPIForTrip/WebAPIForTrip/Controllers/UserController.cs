using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

using WebAPIForTrip.Models;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;
using System.Web.UI.WebControls;
using System.Web;
using System.Web.Mvc;



namespace WebAPIForTrip.Controllers
{
    public class UserController : ApiController
    {
        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("KullaniciBilgileri")]
        public HttpResponseMessage KullaniciBilgileri()
        {
            DataTable table = new DataTable();

            string query = @"SELECT  *  FROM   dbo.UserInformations";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }

/*
        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("SifreGetir")]
        public HttpResponseMessage SifreGetir(KullaniciBilgileri kullaniciBilgileri)
        {
            DataTable table = new DataTable();

            string query = @"SELECT  UserPassword  FROM   dbo.UserInformations where (UserName,UserSurname) '"+kullaniciBilgileri.UserName+"'" ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }


    */





        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("MekanFoto")]
        public HttpResponseMessage MekanFoto([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            DataTable table = new DataTable();

            string query = @"SELECT  MekanFotoURL  FROM   dbo.Turlar where MekanIsimleri= '"+ kullaniciBilgileri.MekanIsimleri + "' ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }



        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("SehirAdlariQuery")]
        public HttpResponseMessage SehirAdlariQuery([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            DataTable table = new DataTable();

            string query = @"SELECT  Sehirler  FROM   dbo.SehirDurumlari where Sehirler= '" + kullaniciBilgileri.Sehirler + "' ";


            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }



        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("SehirAdlari")]
        public HttpResponseMessage SehirAdlari([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            DataTable table = new DataTable();

            string query = @"SELECT  *  FROM   dbo.SehirDurumlari  ";


            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }












        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("TurBilgileri")]

        public HttpResponseMessage TurBilgileri()
        {
            DataTable table = new DataTable();

            string query = @"SELECT  *  FROM   dbo.Turlar";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }


        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("MekanBilgileri")]

        public HttpResponseMessage MekanBilgileri([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            DataTable table = new DataTable();

            string query = @"SELECT MekanIsimleri  FROM   dbo.Turlar where Turİsmi='" + kullaniciBilgileri.turIsmi + "' ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("MekanAciklamasi")]

        public HttpResponseMessage MekanAciklamasi([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            DataTable table = new DataTable();

            string query = @"SELECT MekanAciklamalari  FROM   dbo.Turlar where MekanIsimleri='" + kullaniciBilgileri.MekanIsimleri + "' ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("KordinatGetir")]

        public HttpResponseMessage KordinatGetir([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            DataTable table = new DataTable();

            string query = @"SELECT Kordinatlar  FROM   dbo.Turlar where MekanIsimleri='" + kullaniciBilgileri.MekanIsimleri + "' ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }





        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("TurBilgileriDiscent")]

        public HttpResponseMessage TurBilgileriDiscent()
        {
            DataTable table = new DataTable();

            string query = @"SELECT DISTINCT Turİsmi  FROM   dbo.Turlar";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }
            return Request.CreateResponse(HttpStatusCode.OK, table);


        }

















        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByIdTurBilgileri")]

        public HttpResponseMessage ByIdTurBilgileri(int id)
        {


            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();

            DataTable table = new DataTable();


            string query = "select * from dbo.Turlar where UserId = '" + id + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByIdKullaniciBilgileri")]

        public HttpResponseMessage ByIdKullaniciBilgileri(int id)
        {


            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();

            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserId = '" + id + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByUserNameKullaniciBilgileri")]

        public HttpResponseMessage ByUserNameKullaniciBilgileri2(string userName)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserName = '" + userName + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByTurIsmi")]
        public HttpResponseMessage ByTurIsmi(string turIsmi)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.Turlar where TurIsmi = '" + turIsmi + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }
        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByKordinat")]
        public HttpResponseMessage ByKordinat(string Kordinat)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.Turlar where Kordinatlar = '" + Kordinat + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }





        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByuserSurnameKullaniciBilgileri")]
        public HttpResponseMessage userSurnameKullaniciBilgileri(string userSurname)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserSurname = '" + userSurname + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }


        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByUserMailAdressKullaniciBilgileri")]
        public HttpResponseMessage ByUserMailAdressKullaniciBilgileri(string userMailAdress)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserMailAdress = '" + userMailAdress + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("getNotlar")]
        public HttpResponseMessage getNotlar(string UserNickName)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.Notlar where UserNickName = '" + UserNickName + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }


        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("SifremiUnuttum")]

        public HttpResponseMessage SifremiUnuttum([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            
            DataTable table = new DataTable();

            string query = "select UserPassword from dbo.UserInformations where UserName = '" + kullaniciBilgileri.UserName + "' AND UserSurname='"+kullaniciBilgileri.UserSurname + "' AND UserMailAdress='"+kullaniciBilgileri.UserMailAdress+"' ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }






        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByUserNickNameKullaniciBilgileri")]

        public HttpResponseMessage ByUserNickNameKullaniciBilgileri5(string userNickName)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserNickName = '" + userNickName + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("FavlariGetir")]

        public HttpResponseMessage FavlariGetir([FromUri]KullaniciBilgileri kullanicibilgileri)
        {
            
            DataTable table = new DataTable();


            string query = "select MekanIsimleri from dbo.Favlar where UserNickName = '" + kullanicibilgileri.UserNickName + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("GidilenMekanGetir")]

        public HttpResponseMessage GidilenMekanGetir([FromUri]KullaniciBilgileri kullanicibilgileri)
        {

            DataTable table = new DataTable();


            string query = "select * from dbo.GidilenMekanlarByUsers where UserNickName = '" + kullanicibilgileri.UserNickName + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("TercihEdilenMekanGetir")]

        public HttpResponseMessage TercihEdilenMekanGetir([FromUri]KullaniciBilgileri kullanicibilgileri)
        {

            DataTable table = new DataTable();


            string query = "select GidilenMekan, COUNT(*) AS Occurrences from dbo.GidilenMekanlarByUsers GROUP BY GidilenMekan HAVING (COUNT(*) > 1) ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }






        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("HavaDurumu")]

        public HttpResponseMessage HavaDurumu()
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.HavaDurumu";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByUserPasswordKullaniciBilgileri")]
        public HttpResponseMessage ByUserPasswordKullaniciBilgileri(string userPassword)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserPassword = '" + userPassword + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("YorumGetir")]
        public HttpResponseMessage YorumGetir([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            
            DataTable table = new DataTable();


            string query = "select * from dbo.Yorumlar where UserNickName = '" + kullaniciBilgileri.UserNickName + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.ActionName("ByUserAgainPassword")]
        public HttpResponseMessage ByUserAgainPassword(string userAgainPassword)
        {
            KullaniciBilgileri kullaniciBilgileri = new KullaniciBilgileri();
            DataTable table = new DataTable();


            string query = "select * from dbo.UserInformations where UserAgainPassword = '" + userAgainPassword + "'";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);

            }
            return Request.CreateResponse(HttpStatusCode.OK, table);
        }

        [System.Web.Http.HttpPut]
        [System.Web.Http.ActionName("GuncelleIsim")]

        public HttpResponseMessage GuncelleIsim([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {

            DataTable table = new DataTable();

            string query = @"
                update dbo.UserInformations set UserName = '" + kullaniciBilgileri.UserName + @"'
                    where UserNickName ='" + kullaniciBilgileri.UserNickName + @"'
                    ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }


            return Request.CreateResponse(HttpStatusCode.OK, table);



        }







        [System.Web.Http.HttpPut]
        [System.Web.Http.ActionName("GuncelleSurname")]

        public HttpResponseMessage GuncelleSurname([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {



            DataTable table = new DataTable();

            string query = @"
                update dbo.UserInformations set UserSurname = '" + kullaniciBilgileri.UserSurname + @"'
                    where UserNickName ='" + kullaniciBilgileri.UserNickName + @"'
                    ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }


            return Request.CreateResponse(HttpStatusCode.OK, table);



        }

        [System.Web.Http.HttpPut]
        [System.Web.Http.ActionName("GuncelleMailAdresi")]

        public HttpResponseMessage GuncelleMailAdresi([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {



            DataTable table = new DataTable();

            string query = @"
                update dbo.UserInformations set UserMailAdress = '" + kullaniciBilgileri.UserMailAdress + @"'
                    where UserNickName ='" + kullaniciBilgileri.UserNickName + @"'
                    ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }


            return Request.CreateResponse(HttpStatusCode.OK, table);



        }

        [System.Web.Http.HttpPut]
        [System.Web.Http.ActionName("GuncelleKullaniciAdi")]

        public HttpResponseMessage GuncelleKullaniciAdi([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {



            DataTable table = new DataTable();

            string query = @"
                update dbo.UserInformations set UserNickName = '" + kullaniciBilgileri.UserNickName + @"'
                    where UserNickName ='" + kullaniciBilgileri.UserNickName + @"'
                    ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }


            return Request.CreateResponse(HttpStatusCode.OK, table);



        }


        [System.Web.Http.HttpPut]
        [System.Web.Http.ActionName("GuncelleSifre")]

        public HttpResponseMessage GuncelleSifre([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {



            DataTable table = new DataTable();

            string query = @"
                update dbo.UserInformations set UserPassword = '" + kullaniciBilgileri.UserPassword + @"'
                    where UserNickName ='" + kullaniciBilgileri.UserNickName + @"'
                    ";

            using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
            using (var cmd = new SqlCommand(query, con))
            using (var da = new SqlDataAdapter(cmd))
            {
                cmd.CommandType = CommandType.Text;
                da.Fill(table);


            }


            return Request.CreateResponse(HttpStatusCode.OK, table);



        }



        [System.Web.Http.HttpPost]
        [System.Web.Http.ActionName("KayitOl")]

        public string KayitOl(KullaniciBilgileri kullaniciBilgileri)
        {
            try
            {
                DataTable table = new DataTable();

                string query = @"
                insert into dbo.UserInformations
               (
                UserName,
                UserSurName,
                UserMailAdress,
                UserNickName,
                UserPassword,
                UserAgainPassword)
                Values
                (
                
                '" + kullaniciBilgileri.UserName + @"'
                ,'" + kullaniciBilgileri.UserSurname + @"'
                ,'" + kullaniciBilgileri.UserMailAdress + @"'
                ,'" + kullaniciBilgileri.UserNickName + @"'
                ,'" + kullaniciBilgileri.UserPassword + @"'
                ,'" + kullaniciBilgileri.UserAgainPassword + @"'
                 )
                ";

                using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
                using (var cmd = new SqlCommand(query, con))
                using (var da = new SqlDataAdapter(cmd))
                {
                    cmd.CommandType = CommandType.Text;
                    da.Fill(table);


                }




                return "Added Sucsessfully";
            }
            catch (Exception)
            {


                return "Failed to Add";
            }

        }
        [System.Web.Http.HttpPost]
        [System.Web.Http.ActionName("NotlarKaydet")]

        public string NotlarKaydet(KullaniciBilgileri kullaniciBilgileri)
        {
            try
            {
                DataTable table = new DataTable();

                string query = @"
                insert into dbo.Notlar
               (
                Notlar,
                UserNickName,
                NotBasligi)

                Values
                (
                '" + kullaniciBilgileri.Notlar + @"'
                ,'" + kullaniciBilgileri.UserNickName + @"'
                   ,'" + kullaniciBilgileri.NotBasligi + @"' 
                 )
                ";



                using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
                using (var cmd = new SqlCommand(query, con))
                using (var da = new SqlDataAdapter(cmd))
                {
                    cmd.CommandType = CommandType.Text;
                    da.Fill(table);


                }




                return "Added Sucsessfully";
            }
            catch (Exception)
            {


                return "Failed to Add";
            }

        }


        [System.Web.Http.HttpPost]
        [System.Web.Http.ActionName("GidilenMekanlaraEkle")]

        public string GidilenMekanlaraEkle(KullaniciBilgileri kullaniciBilgileri)
        {
            try
            {
                DataTable table = new DataTable();

                string query = @"
                insert into dbo.GidilenMekanlarByUsers
               (
                UserNickName,
                GidilenMekan
                )

                Values
                (
                '" + kullaniciBilgileri.UserNickName + @"'
                   ,'" + kullaniciBilgileri.GidilenMekan + @"' 
                 )
                ";



                using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
                using (var cmd = new SqlCommand(query, con))
                using (var da = new SqlDataAdapter(cmd))
                {
                    cmd.CommandType = CommandType.Text;
                    da.Fill(table);


                }




                return "Added Sucsessfully";
            }
            catch (Exception)
            {


                return "Failed to Add";
            }

        }




        [System.Web.Http.HttpPost]
        [System.Web.Http.ActionName("YorumYap")]

        public string YorumYap(KullaniciBilgileri kullaniciBilgileri)
        {
            try
            {
                DataTable table = new DataTable();

                string query = @"
                insert into dbo.Yorumlar
               (
                UserNickName,
                Turİsmi,
                Mekanİsimleri,
                MekanYorumu)
                Values
                (
                
                '" + kullaniciBilgileri.UserNickName + @"'
                ,'" + kullaniciBilgileri.turIsmi + @"'
                ,'" + kullaniciBilgileri.MekanIsimleri + @"'
                ,'" + kullaniciBilgileri.MekanYorumu + @"'
                 )
                ";

                using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
                using (var cmd = new SqlCommand(query, con))
                using (var da = new SqlDataAdapter(cmd))
                {
                    cmd.CommandType = CommandType.Text;
                    da.Fill(table);


                }




                return "Added Sucsessfully";
            }
            catch (Exception)
            {


                return "Failed to Add";
            }





        }

        [System.Web.Http.HttpPost]
        [System.Web.Http.ActionName("FavEkle")]

        public string FavEkle(KullaniciBilgileri kullaniciBilgileri)
        {
            try
            {
                DataTable table = new DataTable();

                string query = @"
                insert into dbo.Favlar
               (
                UserNickName,
                MekanIsimleri,
                Favori)
                Values
                (
                
                '" + kullaniciBilgileri.UserNickName + @"'
                ,'" + kullaniciBilgileri.MekanIsimleri + @"'
                ,'" + kullaniciBilgileri.Favori + @"'
                
                 )
                ";

                using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
                using (var cmd = new SqlCommand(query, con))
                using (var da = new SqlDataAdapter(cmd))
                {
                    cmd.CommandType = CommandType.Text;
                    da.Fill(table);


                }




                return "Added Sucsessfully";
            }
            catch (Exception)
            {


                return "Failed to Add";
            }
        }


        [System.Web.Http.HttpDelete]
        [System.Web.Http.ActionName("FavSil")]

        public string FavSil([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            try
            {
                DataTable table = new DataTable();
                string query = "delete from  dbo.Favlar where UserNickName='" + kullaniciBilgileri.UserNickName + "' AND MekanIsimleri= '" + kullaniciBilgileri.MekanIsimleri + "'";


                using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
                using (var cmd = new SqlCommand(query, con))
                using (var da = new SqlDataAdapter(cmd))
                {
                    cmd.CommandType = CommandType.Text;
                    da.Fill(table);


                }




                return "Added Sucsessfully";
            }
            catch (Exception)
            {


                return "Failed to Add";
            }
        }

            [System.Web.Http.HttpDelete]
            [System.Web.Http.ActionName("YorumSil")]

        public string YorumSil([FromUri]KullaniciBilgileri kullaniciBilgileri)
        {
            try
            {
                DataTable table = new DataTable();
                string query = "delete from  dbo.Yorumlar where UserNickName='" + kullaniciBilgileri.UserNickName + "' AND MekanYorumu= '" + kullaniciBilgileri.MekanYorumu + "'";


                using (var con = new SqlConnection(ConfigurationManager.ConnectionStrings["KullaniciBilgileriDB"].ConnectionString))
                using (var cmd = new SqlCommand(query, con))
                using (var da = new SqlDataAdapter(cmd))
                {
                    cmd.CommandType = CommandType.Text;
                    da.Fill(table);


                }




                return "Added Sucsessfully";
            }
            catch (Exception)
            {


                return "Failed to Add";
            }








        }

    }

}

