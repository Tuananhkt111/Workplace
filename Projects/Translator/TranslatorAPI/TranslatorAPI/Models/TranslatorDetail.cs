using System;
using System.Collections.Generic;

namespace TranslatorAPI.Models
{
    public partial class TranslatorDetail
    {
        public int TranslatorDetailId { get; set; }
        public string Description { get; set; }
        public string Language { get; set; }
        public string UserId { get; set; }
        public double? StandardLv { get; set; }

        public virtual TranslatorAPIUser User { get; set; }
    }
}
