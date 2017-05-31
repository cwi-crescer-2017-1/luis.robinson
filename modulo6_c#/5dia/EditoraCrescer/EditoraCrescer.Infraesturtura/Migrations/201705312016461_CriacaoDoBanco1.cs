namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBanco1 : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Revisores",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            AddColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            AddColumn("dbo.Livros", "DataRevisao", c => c.DateTime(nullable: false));
            AddColumn("dbo.Livros", "UrlCapa", c => c.String());
            CreateIndex("dbo.Livros", "IdRevisor");
            //AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            //DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            DropColumn("dbo.Livros", "UrlCapa");
            DropColumn("dbo.Livros", "DataRevisao");
            DropColumn("dbo.Livros", "IdRevisor");
            DropTable("dbo.Revisores");
        }
    }
}
